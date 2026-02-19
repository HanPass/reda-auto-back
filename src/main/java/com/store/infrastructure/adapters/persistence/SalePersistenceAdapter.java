package com.store.infrastructure.adapters.persistence;
import com.store.domain.model.Sale;
import com.store.domain.ports.SalePort;
import com.store.infrastructure.adapters.persistence.mapper.SaleEntityMapper;
import com.store.infrastructure.adapters.persistence.repository.SaleJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
@Component @RequiredArgsConstructor
public class SalePersistenceAdapter implements SalePort {
    private final SaleJpaRepository repo; private final SaleEntityMapper mapper;
    public Sale save(Sale s){ return mapper.toDomain(repo.save(mapper.toEntity(s))); }
    public List<Sale> findAll(){ return repo.findAll().stream().map(mapper::toDomain).toList(); }
}
