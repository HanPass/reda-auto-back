package com.store.infrastructure.adapters.persistence;
import com.store.domain.model.Client;
import com.store.domain.ports.ClientPort;
import com.store.infrastructure.adapters.persistence.mapper.ClientEntityMapper;
import com.store.infrastructure.adapters.persistence.repository.ClientJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.*;
@Component @RequiredArgsConstructor
public class ClientPersistenceAdapter implements ClientPort {
    private final ClientJpaRepository repo; private final ClientEntityMapper mapper;
    public Client save(Client c){ return mapper.toDomain(repo.save(mapper.toEntity(c))); }
    public Optional<Client> findById(Long id){ return repo.findById(id).map(mapper::toDomain); }
    public List<Client> findAll(){ return repo.findAll().stream().map(mapper::toDomain).toList(); }
    public void deleteById(Long id){ repo.deleteById(id); }
}
