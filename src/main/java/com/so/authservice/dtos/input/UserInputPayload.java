package com.so.authservice.dtos.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Valid
public class UserInputPayload {
    @NotBlank(message = "username must not be empty or null")
    private String username;
    @NotBlank(message = "username must not be empty or null")
    private String password;
}
