package com.vitorpereira.backend.mappers;

import com.vitorpereira.backend.dto.UserDto;
import com.vitorpereira.backend.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);
}
