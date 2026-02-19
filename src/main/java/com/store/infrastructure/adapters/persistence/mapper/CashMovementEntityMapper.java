package com.store.infrastructure.adapters.persistence.mapper;

import com.store.domain.model.CashMovement;
import com.store.infrastructure.adapters.persistence.entity.CashMovementEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CashMovementEntityMapper {
    CashMovement toDomain(CashMovementEntity e);
    CashMovementEntity toEntity(CashMovement d);
}
