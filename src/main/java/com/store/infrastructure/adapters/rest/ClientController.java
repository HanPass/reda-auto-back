package com.store.infrastructure.adapters.rest;
import com.store.application.dto.ClientDto;
import com.store.application.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/clients") @RequiredArgsConstructor
public class ClientController {
    private final ClientService service;
    @PostMapping public ClientDto create(@Valid @RequestBody ClientDto dto){ return service.create(dto); }
    @GetMapping public List<ClientDto> all(){ return service.all(); }
    @GetMapping("/{id}") public ClientDto byId(@PathVariable Long id){ return service.byId(id); }
    @PutMapping("/{id}") public ClientDto update(@PathVariable Long id,@Valid @RequestBody ClientDto dto){ return service.update(id,dto); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ service.delete(id); }
}
