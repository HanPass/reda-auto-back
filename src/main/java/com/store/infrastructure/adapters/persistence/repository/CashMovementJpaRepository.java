package com.store.infrastructure.adapters.persistence.repository;
import com.store.infrastructure.adapters.persistence.entity.CashMovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CashMovementJpaRepository extends JpaRepository<CashMovementEntity, Long> {}
