package com.store.application.mapper;

import com.store.application.dto.SupplierDto;
import com.store.domain.model.Supplier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierDtoMapper {
    Supplier toDomain(SupplierDto dto);
    SupplierDto toDto(Supplier domain);
}
