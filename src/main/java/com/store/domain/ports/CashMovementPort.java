package com.store.domain.ports;

import com.store.domain.model.CashMovement;

public interface CashMovementPort {
    CashMovement save(CashMovement movement);
}
