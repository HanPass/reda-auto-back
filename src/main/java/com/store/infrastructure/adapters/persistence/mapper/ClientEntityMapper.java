package com.store.infrastructure.adapters.persistence.mapper;

import com.store.domain.model.Client;
import com.store.infrastructure.adapters.persistence.entity.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientEntityMapper {
    Client toDomain(ClientEntity e);
    ClientEntity toEntity(Client d);
}
