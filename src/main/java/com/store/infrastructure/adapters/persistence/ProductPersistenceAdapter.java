package com.store.infrastructure.adapters.persistence;

import com.store.domain.model.Product;
import com.store.domain.ports.ProductPort;
import com.store.infrastructure.adapters.persistence.mapper.ProductEntityMapper;
import com.store.infrastructure.adapters.persistence.repository.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.*;

@Component @RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductPort {
    private final ProductJpaRepository repo; private final ProductEntityMapper mapper;
    public Product save(Product p){ return mapper.toDomain(repo.save(mapper.toEntity(p))); }
    public Optional<Product> findById(Long id){ return repo.findById(id).map(mapper::toDomain); }
    public Optional<Product> findByReference(String reference){ return repo.findByReference(reference).map(mapper::toDomain); }
    public List<Product> findAll(){ return repo.findAll().stream().map(mapper::toDomain).toList(); }
    public List<Product> findByNomContaining(String nom){ return repo.findByNomContainingIgnoreCase(nom).stream().map(mapper::toDomain).toList(); }
    public List<Product> findLowStock(){ return repo.findAll().stream().filter(p -> p.getQuantiteStock() <= p.getSeuilAlerte()).map(mapper::toDomain).toList(); }
    public void deleteById(Long id){ repo.deleteById(id); }
}
