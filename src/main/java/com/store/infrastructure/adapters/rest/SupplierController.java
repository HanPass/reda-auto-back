package com.store.infrastructure.adapters.rest;
import com.store.application.dto.SupplierDto;
import com.store.application.service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/suppliers") @RequiredArgsConstructor
public class SupplierController {
    private final SupplierService service;
    @PostMapping public SupplierDto create(@Valid @RequestBody SupplierDto dto){ return service.create(dto); }
    @GetMapping public List<SupplierDto> all(){ return service.all(); }
    @GetMapping("/{id}") public SupplierDto byId(@PathVariable Long id){ return service.byId(id); }
    @PutMapping("/{id}") public SupplierDto update(@PathVariable Long id,@Valid @RequestBody SupplierDto dto){ return service.update(id,dto); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ service.delete(id); }
}
