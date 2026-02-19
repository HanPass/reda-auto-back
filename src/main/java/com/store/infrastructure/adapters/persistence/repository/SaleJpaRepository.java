package com.store.infrastructure.adapters.persistence.repository;
import com.store.infrastructure.adapters.persistence.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SaleJpaRepository extends JpaRepository<SaleEntity, Long> {}
