package com.store.infrastructure.adapters.persistence.mapper;

import com.store.domain.model.Supplier;
import com.store.infrastructure.adapters.persistence.entity.SupplierEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierEntityMapper {
    Supplier toDomain(SupplierEntity e);
    SupplierEntity toEntity(Supplier d);
}
