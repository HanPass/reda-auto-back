package com.store.infrastructure.adapters.persistence.repository;
import com.store.infrastructure.adapters.persistence.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SupplierJpaRepository extends JpaRepository<SupplierEntity, Long> {}
