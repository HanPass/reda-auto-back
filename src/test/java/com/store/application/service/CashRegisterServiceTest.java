package com.store.application.service;

import com.store.application.exception.BusinessException;
import com.store.domain.model.CashRegister;
import com.store.domain.ports.CashMovementPort;
import com.store.domain.ports.CashRegisterPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CashRegisterServiceTest {
    @Mock CashRegisterPort cashRegisterPort;
    @Mock CashMovementPort movementPort;
    @InjectMocks CashRegisterService service;

    @Test
    void shouldRejectSecondOpenRegisterSameDay() {
        when(cashRegisterPort.findOpenByDate(LocalDate.now())).thenReturn(Optional.of(CashRegister.builder().id(1L).build()));
        assertThrows(BusinessException.class, () -> service.open(BigDecimal.TEN));
    }
}
