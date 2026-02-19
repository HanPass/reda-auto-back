package com.store.infrastructure.adapters.persistence;
import com.store.domain.model.Supplier;
import com.store.domain.ports.SupplierPort;
import com.store.infrastructure.adapters.persistence.mapper.SupplierEntityMapper;
import com.store.infrastructure.adapters.persistence.repository.SupplierJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.*;
@Component @RequiredArgsConstructor
public class SupplierPersistenceAdapter implements SupplierPort {
    private final SupplierJpaRepository repo; private final SupplierEntityMapper mapper;
    public Supplier save(Supplier s){ return mapper.toDomain(repo.save(mapper.toEntity(s))); }
    public Optional<Supplier> findById(Long id){ return repo.findById(id).map(mapper::toDomain); }
    public List<Supplier> findAll(){ return repo.findAll().stream().map(mapper::toDomain).toList(); }
    public void deleteById(Long id){ repo.deleteById(id); }
}
