package com.vitorpereira.backend.mappers;

import com.vitorpereira.backend.dto.SignUpDto;
import com.vitorpereira.backend.dto.UserDto;
import com.vitorpereira.backend.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore=true)
    User signUpToUser(SignUpDto signUpDto);
}
