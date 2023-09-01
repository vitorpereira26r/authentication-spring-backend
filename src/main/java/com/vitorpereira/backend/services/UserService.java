package com.vitorpereira.backend.services;

import com.vitorpereira.backend.dto.CredencialsDto;
import com.vitorpereira.backend.dto.UserDto;
import com.vitorpereira.backend.entities.User;
import com.vitorpereira.backend.exceptions.AppException;
import com.vitorpereira.backend.mappers.UserMapper;
import com.vitorpereira.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private UserMapper userMapper;

    public UserDto login(CredencialsDto credencialsDto){
        User user = userRepository.findByLogin(credencialsDto.login())
                .orElseThrow(() -> new AppException("Unknown User", HttpStatus.NOT_FOUND));

        if(passwordEncoder.matches(CharBuffer.wrap(credencialsDto.password()), user.getPassword())){
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }
}
