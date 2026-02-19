package com.store.infrastructure.adapters.persistence.repository;

import com.store.infrastructure.adapters.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByReference(String reference);
    List<ProductEntity> findByNomContainingIgnoreCase(String nom);
    List<ProductEntity> findByQuantiteStockLessThanEqual(Integer seuilAlerte);
}
