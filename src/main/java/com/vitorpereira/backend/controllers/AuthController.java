package com.vitorpereira.backend.controllers;

import com.vitorpereira.backend.dto.CredencialsDto;
import com.vitorpereira.backend.dto.UserDto;
import com.vitorpereira.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody CredencialsDto credencialsDto){
        UserDto user = userService.login(credencialsDto);
        return ResponseEntity.ok(user);
    }
}
