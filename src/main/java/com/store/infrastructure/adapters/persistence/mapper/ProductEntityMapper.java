package com.store.infrastructure.adapters.persistence.mapper;

import com.store.domain.model.Product;
import com.store.infrastructure.adapters.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {
    Product toDomain(ProductEntity e);
    ProductEntity toEntity(Product d);
}
