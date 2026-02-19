package com.store.infrastructure.adapters.persistence;
import com.store.domain.model.CashMovement;
import com.store.domain.ports.CashMovementPort;
import com.store.infrastructure.adapters.persistence.mapper.CashMovementEntityMapper;
import com.store.infrastructure.adapters.persistence.repository.CashMovementJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@Component @RequiredArgsConstructor
public class CashMovementPersistenceAdapter implements CashMovementPort {
    private final CashMovementJpaRepository repo; private final CashMovementEntityMapper mapper;
    public CashMovement save(CashMovement m){ return mapper.toDomain(repo.save(mapper.toEntity(m))); }
}
