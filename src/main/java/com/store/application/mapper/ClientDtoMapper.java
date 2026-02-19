package com.store.application.mapper;

import com.store.application.dto.ClientDto;
import com.store.domain.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientDtoMapper {
    Client toDomain(ClientDto dto);
    ClientDto toDto(Client domain);
}
