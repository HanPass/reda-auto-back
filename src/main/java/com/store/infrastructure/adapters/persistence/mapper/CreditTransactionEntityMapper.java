package com.store.infrastructure.adapters.persistence.mapper;

import com.store.domain.model.CreditTransaction;
import com.store.infrastructure.adapters.persistence.entity.CreditTransactionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditTransactionEntityMapper {
    CreditTransaction toDomain(CreditTransactionEntity e);
    CreditTransactionEntity toEntity(CreditTransaction d);
}
