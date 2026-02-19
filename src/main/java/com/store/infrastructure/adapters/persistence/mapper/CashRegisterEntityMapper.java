package com.store.infrastructure.adapters.persistence.mapper;

import com.store.domain.model.CashRegister;
import com.store.infrastructure.adapters.persistence.entity.CashRegisterEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CashRegisterEntityMapper {
    CashRegister toDomain(CashRegisterEntity e);
    CashRegisterEntity toEntity(CashRegister d);
}
