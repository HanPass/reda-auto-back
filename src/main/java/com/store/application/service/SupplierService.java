package com.store.application.service;

import com.store.application.dto.SupplierDto;
import com.store.application.exception.NotFoundException;
import com.store.domain.model.Supplier;
import com.store.domain.ports.SupplierPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service @RequiredArgsConstructor
public class SupplierService {
    private final SupplierPort supplierPort;
    private final com.store.application.mapper.SupplierDtoMapper mapper;

    public SupplierDto create(SupplierDto dto){ return mapper.toDto(supplierPort.save(mapper.toDomain(dto))); }
    public List<SupplierDto> all(){ return supplierPort.findAll().stream().map(mapper::toDto).toList(); }
    public SupplierDto byId(Long id){ return mapper.toDto(supplierPort.findById(id).orElseThrow(() -> new NotFoundException("Fournisseur introuvable"))); }
    public SupplierDto update(Long id, SupplierDto dto){ Supplier s=mapper.toDomain(dto); s.setId(id); return mapper.toDto(supplierPort.save(s)); }
    public void delete(Long id){ supplierPort.deleteById(id); }
}
