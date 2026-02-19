package com.store.infrastructure.adapters.persistence;
import com.store.domain.model.CreditTransaction;
import com.store.domain.ports.CreditTransactionPort;
import com.store.infrastructure.adapters.persistence.mapper.CreditTransactionEntityMapper;
import com.store.infrastructure.adapters.persistence.repository.CreditTransactionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
@Component @RequiredArgsConstructor
public class CreditTransactionPersistenceAdapter implements CreditTransactionPort {
    private final CreditTransactionJpaRepository repo; private final CreditTransactionEntityMapper mapper;
    public CreditTransaction save(CreditTransaction tx){ return mapper.toDomain(repo.save(mapper.toEntity(tx))); }
    public List<CreditTransaction> findByClientId(Long clientId){ return repo.findByClientId(clientId).stream().map(mapper::toDomain).toList(); }
}
