package com.store.infrastructure.adapters.rest;

import com.store.application.dto.ProductDto;
import com.store.application.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/products") @RequiredArgsConstructor
public class ProductController {
    private final ProductService service;
    @PostMapping @PreAuthorize("hasRole('ADMIN')") public ProductDto create(@Valid @RequestBody ProductDto dto){ return service.create(dto); }
    @GetMapping public List<ProductDto> all(){ return service.findAll(); }
    @GetMapping("/{id}") public ProductDto byId(@PathVariable Long id){ return service.findById(id); }
    @PutMapping("/{id}") @PreAuthorize("hasRole('ADMIN')") public ProductDto update(@PathVariable Long id,@Valid @RequestBody ProductDto dto){ return service.update(id,dto); }
    @DeleteMapping("/{id}") @PreAuthorize("hasRole('ADMIN')") public void delete(@PathVariable Long id){ service.delete(id); }
    @GetMapping("/search") public List<ProductDto> search(@RequestParam(required = false) String ref,@RequestParam(required = false) String nom){
        if (ref != null) return List.of(service.searchByReference(ref));
        return service.searchByName(nom == null ? "" : nom);
    }
    @GetMapping("/low-stock") public List<ProductDto> lowStock(){ return service.lowStock(); }
}
