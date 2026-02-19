package com.store.infrastructure.adapters.persistence.repository;
import com.store.infrastructure.adapters.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClientJpaRepository extends JpaRepository<ClientEntity, Long> {}
