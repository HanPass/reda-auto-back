package com.store.domain.ports;

import com.store.domain.model.CreditTransaction;
import java.util.List;

public interface CreditTransactionPort {
    CreditTransaction save(CreditTransaction tx);
    List<CreditTransaction> findByClientId(Long clientId);
}
