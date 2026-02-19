package com.store.application.mapper;

import com.store.application.dto.ProductDto;
import com.store.domain.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDtoMapper {
    Product toDomain(ProductDto dto);
    ProductDto toDto(Product domain);
}
