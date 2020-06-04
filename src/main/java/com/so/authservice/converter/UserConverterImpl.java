package com.so.authservice.converter;

import org.springframework.stereotype.Service;

import com.so.authservice.data.Authority;
import com.so.authservice.data.User;
import com.so.authservice.dtos.output.UserOutputPayload;
import java.util.stream.Collectors;

@Service
public class UserConverterImpl implements UserConverter {

    @Override
    public UserOutputPayload convert(User user) {
        return new UserOutputPayload(user.getId(), user.getRoles().stream()
            .flatMap(role -> role.getPermissions().stream())
            .map(Authority::getPermission)
            .collect(Collectors.toSet()));
    }
}
