package com.store.application.service;

import com.store.application.dto.SaleLineRequest;
import com.store.application.dto.SaleRequest;
import com.store.application.exception.BusinessException;
import com.store.application.exception.NotFoundException;
import com.store.domain.enums.CashMovementType;
import com.store.domain.enums.CreditTransactionType;
import com.store.domain.enums.PaymentMode;
import com.store.domain.model.*;
import com.store.domain.ports.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SalePort salePort;
    private final ProductPort productPort;
    private final ClientPort clientPort;
    private final CreditTransactionPort creditTransactionPort;
    private final CashRegisterPort cashRegisterPort;
    private final CashMovementPort cashMovementPort;

    @Transactional
    public Sale create(SaleRequest request) {
        BigDecimal total = BigDecimal.ZERO;
        for (SaleLineRequest l : request.lignes()) {
            Product p = productPort.findById(l.produitId()).orElseThrow(() -> new NotFoundException("Produit introuvable"));
            if (p.getQuantiteStock() < l.quantite()) throw new BusinessException("Stock insuffisant");
            p.setQuantiteStock(p.getQuantiteStock() - l.quantite());
            productPort.save(p);
            total = total.add(l.prixUnitaire().multiply(BigDecimal.valueOf(l.quantite())));
        }
        if (request.modePaiement() == PaymentMode.CREDIT) {
            Client c = clientPort.findById(request.clientId()).orElseThrow(() -> new NotFoundException("Client introuvable"));
            BigDecimal newCredit = c.getMontantCreditActuel().add(total);
            if (newCredit.compareTo(c.getPlafondCredit()) > 0) throw new BusinessException("Plafond crédit dépassé");
            c.setMontantCreditActuel(newCredit);
            clientPort.save(c);
            creditTransactionPort.save(CreditTransaction.builder().clientId(c.getId()).montant(total).type(CreditTransactionType.VENTE_CREDIT).date(LocalDateTime.now()).build());
        } else if (request.modePaiement() == PaymentMode.CASH) {
            CashRegister caisse = cashRegisterPort.findOpenByDate(java.time.LocalDate.now()).orElseThrow(() -> new BusinessException("Aucune caisse ouverte"));
            cashMovementPort.save(CashMovement.builder().caisseId(caisse.getId()).type(CashMovementType.ENTREE).montant(total).description("Vente cash").date(LocalDateTime.now()).build());
            caisse.setTotalEntrees(caisse.getTotalEntrees().add(total));
            caisse.setSoldeTheorique(caisse.getMontantInitial().add(caisse.getTotalEntrees()).subtract(caisse.getTotalSorties()));
            cashRegisterPort.save(caisse);
        }
        Sale sale = Sale.builder().date(LocalDateTime.now()).modePaiement(request.modePaiement()).clientId(request.clientId()).total(total)
                .numeroFacture("FAC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase())
                .lignes(request.lignes().stream().map(l -> SaleLine.builder().produitId(l.produitId()).quantite(l.quantite()).prixUnitaire(l.prixUnitaire()).build()).toList())
                .build();
        return salePort.save(sale);
    }
}
