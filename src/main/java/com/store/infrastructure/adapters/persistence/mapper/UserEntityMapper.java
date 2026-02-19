package com.store.infrastructure.adapters.persistence.mapper;

import com.store.domain.model.User;
import com.store.infrastructure.adapters.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    User toDomain(UserEntity e);
    UserEntity toEntity(User d);
}
