package com.so.authservice.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.so.authservice.converter.UserConverter;
import com.so.authservice.dtos.input.UserInputPayload;
import com.so.authservice.dtos.output.UserOutputPayload;
import com.so.authservice.service.AuthService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/so/auth")
public class AuthController {

    private final AuthService authService;
    private final UserConverter userConverter;

    @PostMapping
    public String generateAuthToken(@RequestBody UserInputPayload user) {
        return authService.generateToken(user);
    }

    @GetMapping
    public UserOutputPayload validateUserToken(@RequestHeader("Authorization") String token) {
        return userConverter.convert(authService.validateToken(token));
    }

}
