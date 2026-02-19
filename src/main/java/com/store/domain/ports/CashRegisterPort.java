package com.store.domain.ports;

import com.store.domain.model.CashRegister;
import java.time.LocalDate;
import java.util.Optional;

public interface CashRegisterPort {
    CashRegister save(CashRegister cashRegister);
    Optional<CashRegister> findOpenByDate(LocalDate date);
    Optional<CashRegister> findById(Long id);
}
