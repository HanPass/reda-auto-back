package com.store.infrastructure.adapters.persistence.mapper;

import com.store.domain.model.Sale;
import com.store.infrastructure.adapters.persistence.entity.SaleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleEntityMapper {
    Sale toDomain(SaleEntity e);
    SaleEntity toEntity(Sale d);
}
