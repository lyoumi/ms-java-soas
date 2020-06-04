package com.so.authservice.service;

import org.springframework.stereotype.Service;

import com.so.authservice.data.User;
import com.so.authservice.dtos.input.UserInputPayload;
import com.so.authservice.exception.TokenGenerationException;
import com.so.authservice.exception.TokenValidationException;
import com.so.authservice.repository.UserRepository;
import com.so.authservice.security.JwtTokenUtil;
import java.util.Optional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public String generateToken(UserInputPayload inputPayload) {
        User user = Optional.ofNullable(userRepository.findUserByUsername(inputPayload.getUsername()))
            .orElseThrow(() ->
                new TokenGenerationException(String.format("Unable to find user with username: %s", inputPayload.getUsername())));
        if (!user.isAccountNonLocked() || user.isCredentialsNonExpired() || user.isAccountNonExpired()) {
            throw new TokenGenerationException(
                String.format("Unable to generate token for user %s: {locked: %s, credentials expired: %s, account expired: %s}",
                    user.getUsername(), !user.isAccountNonLocked(), !user.isCredentialsNonExpired(), !user.isAccountNonExpired()));
        }
        return jwtTokenUtil.generateToken(user);
    }

    @Override
    public User validateToken(String token) {
        if (jwtTokenUtil.isTokenExpired(token)) {
            throw new TokenValidationException("Token expired");
        }

        String username = jwtTokenUtil.getUsernameFromToken(token);

        return userRepository.findUserByUsername(username);
    }
}
