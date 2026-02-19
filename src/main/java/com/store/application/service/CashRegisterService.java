package com.store.application.service;

import com.store.application.exception.BusinessException;
import com.store.application.exception.NotFoundException;
import com.store.domain.enums.CashRegisterStatus;
import com.store.domain.model.CashMovement;
import com.store.domain.model.CashRegister;
import com.store.domain.ports.CashMovementPort;
import com.store.domain.ports.CashRegisterPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CashRegisterService {
    private final CashRegisterPort cashRegisterPort;
    private final CashMovementPort movementPort;

    @Transactional
    public CashRegister open(BigDecimal montantInitial) {
        LocalDate today = LocalDate.now();
        if (cashRegisterPort.findOpenByDate(today).isPresent()) throw new BusinessException("Une caisse est déjà ouverte aujourd'hui");
        return cashRegisterPort.save(CashRegister.builder().date(today).montantInitial(montantInitial)
                .totalEntrees(BigDecimal.ZERO).totalSorties(BigDecimal.ZERO).soldeTheorique(montantInitial)
                .soldeReel(BigDecimal.ZERO).statut(CashRegisterStatus.OUVERTE).build());
    }

    @Transactional
    public CashRegister close(Long id, BigDecimal soldeReel) {
        CashRegister c = cashRegisterPort.findById(id).orElseThrow(() -> new NotFoundException("Caisse introuvable"));
        c.setSoldeReel(soldeReel); c.setStatut(CashRegisterStatus.FERMEE);
        return cashRegisterPort.save(c);
    }

    @Transactional
    public void addMovement(CashMovement movement) {
        CashRegister c = cashRegisterPort.findById(movement.getCaisseId()).orElseThrow(() -> new NotFoundException("Caisse introuvable"));
        if (movement.getType().name().equals("ENTREE")) c.setTotalEntrees(c.getTotalEntrees().add(movement.getMontant()));
        else c.setTotalSorties(c.getTotalSorties().add(movement.getMontant()));
        c.setSoldeTheorique(c.getMontantInitial().add(c.getTotalEntrees()).subtract(c.getTotalSorties()));
        cashRegisterPort.save(c);
        movementPort.save(movement);
    }
}
