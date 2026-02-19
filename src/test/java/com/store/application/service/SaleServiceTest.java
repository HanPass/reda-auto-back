package com.store.application.service;

import com.store.application.dto.SaleLineRequest;
import com.store.application.dto.SaleRequest;
import com.store.domain.enums.PaymentMode;
import com.store.domain.model.*;
import com.store.domain.ports.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SaleServiceTest {
    @Mock SalePort salePort; @Mock ProductPort productPort; @Mock ClientPort clientPort;
    @Mock CreditTransactionPort creditTxPort; @Mock CashRegisterPort cashRegisterPort; @Mock CashMovementPort cashMovementPort;
    @InjectMocks SaleService saleService;

    @Test
    void shouldDeductStockAndCreateCreditTx() {
        Product p = Product.builder().id(1L).quantiteStock(10).build();
        Client c = Client.builder().id(2L).plafondCredit(new BigDecimal("1000")).montantCreditActuel(BigDecimal.ZERO).build();
        when(productPort.findById(1L)).thenReturn(Optional.of(p));
        when(clientPort.findById(2L)).thenReturn(Optional.of(c));
        when(salePort.save(any())).thenAnswer(i -> i.getArgument(0));

        saleService.create(new SaleRequest(PaymentMode.CREDIT, 2L, List.of(new SaleLineRequest(1L, 2, new BigDecimal("50")))));

        verify(productPort).save(argThat(prod -> prod.getQuantiteStock()==8));
        verify(creditTxPort).save(any());
    }

    @Test
    void shouldCreateCashMovementForCashPayment() {
        Product p = Product.builder().id(1L).quantiteStock(10).build();
        CashRegister caisse = CashRegister.builder().id(10L).date(LocalDate.now()).montantInitial(BigDecimal.ZERO).totalEntrees(BigDecimal.ZERO).totalSorties(BigDecimal.ZERO).build();
        when(productPort.findById(1L)).thenReturn(Optional.of(p));
        when(cashRegisterPort.findOpenByDate(any())).thenReturn(Optional.of(caisse));
        when(salePort.save(any())).thenAnswer(i -> i.getArgument(0));

        saleService.create(new SaleRequest(PaymentMode.CASH, null, List.of(new SaleLineRequest(1L, 1, new BigDecimal("100")))));

        verify(cashMovementPort).save(any());
        verify(cashRegisterPort).save(argThat(c -> c.getTotalEntrees().compareTo(new BigDecimal("100"))==0));
    }
}
