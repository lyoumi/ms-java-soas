package com.so.authservice.dtos.output;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserOutputPayload {
    private String userId;
    private Set<String> permissions;
}
