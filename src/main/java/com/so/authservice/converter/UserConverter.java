package com.so.authservice.converter;

import com.so.authservice.data.User;
import com.so.authservice.dtos.output.UserOutputPayload;

public interface UserConverter {

    UserOutputPayload convert(User user);
}
