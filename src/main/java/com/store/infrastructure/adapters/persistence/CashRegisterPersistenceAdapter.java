package com.store.infrastructure.adapters.persistence;
import com.store.domain.enums.CashRegisterStatus;
import com.store.domain.model.CashRegister;
import com.store.domain.ports.CashRegisterPort;
import com.store.infrastructure.adapters.persistence.mapper.CashRegisterEntityMapper;
import com.store.infrastructure.adapters.persistence.repository.CashRegisterJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.Optional;
@Component @RequiredArgsConstructor
public class CashRegisterPersistenceAdapter implements CashRegisterPort {
    private final CashRegisterJpaRepository repo; private final CashRegisterEntityMapper mapper;
    public CashRegister save(CashRegister c){ return mapper.toDomain(repo.save(mapper.toEntity(c))); }
    public Optional<CashRegister> findOpenByDate(LocalDate date){ return repo.findByDateAndStatut(date, CashRegisterStatus.OUVERTE).map(mapper::toDomain); }
    public Optional<CashRegister> findById(Long id){ return repo.findById(id).map(mapper::toDomain); }
}
