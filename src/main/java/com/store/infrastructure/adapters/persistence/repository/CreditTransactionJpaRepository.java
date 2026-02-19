package com.store.infrastructure.adapters.persistence.repository;
import com.store.infrastructure.adapters.persistence.entity.CreditTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CreditTransactionJpaRepository extends JpaRepository<CreditTransactionEntity, Long> { List<CreditTransactionEntity> findByClientId(Long clientId); }
