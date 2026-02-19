package com.store.domain.ports;

import com.store.domain.model.Client;
import java.util.List;
import java.util.Optional;

public interface ClientPort {
    Client save(Client client);
    Optional<Client> findById(Long id);
    List<Client> findAll();
    void deleteById(Long id);
}
