package com.store.infrastructure.adapters.persistence.repository;

import com.store.infrastructure.adapters.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> { Optional<UserEntity> findByUsername(String username); }
