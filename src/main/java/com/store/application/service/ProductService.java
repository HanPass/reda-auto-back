package com.store.application.service;

import com.store.application.dto.ProductDto;
import com.store.application.exception.NotFoundException;
import com.store.domain.model.Product;
import com.store.domain.ports.ProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductPort productPort;
    private final com.store.application.mapper.ProductDtoMapper mapper;

    public ProductDto create(ProductDto dto) { return mapper.toDto(productPort.save(mapper.toDomain(dto))); }
    public List<ProductDto> findAll() { return productPort.findAll().stream().map(mapper::toDto).toList(); }
    public ProductDto findById(Long id) { return mapper.toDto(productPort.findById(id).orElseThrow(() -> new NotFoundException("Produit introuvable"))); }
    public ProductDto update(Long id, ProductDto dto) { Product p = mapper.toDomain(dto); p.setId(id); return mapper.toDto(productPort.save(p)); }
    public void delete(Long id) { productPort.deleteById(id); }
    public List<ProductDto> searchByName(String name) { return productPort.findByNomContaining(name).stream().map(mapper::toDto).toList(); }
    public ProductDto searchByReference(String ref) { return mapper.toDto(productPort.findByReference(ref).orElseThrow(() -> new NotFoundException("Produit introuvable"))); }
    public List<ProductDto> lowStock() { return productPort.findLowStock().stream().map(mapper::toDto).toList(); }
}
