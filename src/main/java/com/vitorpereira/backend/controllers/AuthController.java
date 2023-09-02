package com.vitorpereira.backend.controllers;

import com.vitorpereira.backend.dto.CredencialsDto;
import com.vitorpereira.backend.dto.SignUpDto;
import com.vitorpereira.backend.dto.UserDto;
import com.vitorpereira.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody CredencialsDto credencialsDto){
        UserDto user = userService.login(credencialsDto);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody SignUpDto signUpDto){
        UserDto user = userService.register(signUpDto);
        return ResponseEntity.created(URI.create("/users/" + user.getId())).body(user);
    }
}
