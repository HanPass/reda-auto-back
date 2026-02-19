package com.store.infrastructure.adapters.persistence.repository;
import com.store.domain.enums.CashRegisterStatus;
import com.store.infrastructure.adapters.persistence.entity.CashRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.Optional;
public interface CashRegisterJpaRepository extends JpaRepository<CashRegisterEntity, Long> { Optional<CashRegisterEntity> findByDateAndStatut(LocalDate date, CashRegisterStatus statut); }
