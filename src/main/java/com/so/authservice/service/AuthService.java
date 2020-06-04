package com.so.authservice.service;

import com.so.authservice.data.User;
import com.so.authservice.dtos.input.UserInputPayload;

public interface AuthService {

    String generateToken(UserInputPayload user);

    User validateToken(String token);
}
