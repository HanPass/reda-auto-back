package com.store.infrastructure.adapters.persistence;

import com.store.domain.model.User;
import com.store.domain.ports.UserPort;
import com.store.infrastructure.adapters.persistence.mapper.UserEntityMapper;
import com.store.infrastructure.adapters.persistence.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component @RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPort {
    private final UserJpaRepository repo; private final UserEntityMapper mapper;
    public User save(User user){ return mapper.toDomain(repo.save(mapper.toEntity(user))); }
    public Optional<User> findByUsername(String username){ return repo.findByUsername(username).map(mapper::toDomain); }
}
