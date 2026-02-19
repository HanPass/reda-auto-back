package com.store.application.service;

import com.store.application.dto.ClientDto;
import com.store.application.exception.NotFoundException;
import com.store.domain.model.Client;
import com.store.domain.ports.ClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service @RequiredArgsConstructor
public class ClientService {
    private final ClientPort clientPort;
    private final com.store.application.mapper.ClientDtoMapper mapper;

    public ClientDto create(ClientDto dto){ return mapper.toDto(clientPort.save(mapper.toDomain(dto))); }
    public List<ClientDto> all(){ return clientPort.findAll().stream().map(mapper::toDto).toList(); }
    public ClientDto byId(Long id){ return mapper.toDto(clientPort.findById(id).orElseThrow(() -> new NotFoundException("Client introuvable"))); }
    public ClientDto update(Long id, ClientDto dto){ Client c=mapper.toDomain(dto); c.setId(id); return mapper.toDto(clientPort.save(c)); }
    public void delete(Long id){ clientPort.deleteById(id); }
}
