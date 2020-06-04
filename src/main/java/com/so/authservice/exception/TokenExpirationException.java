package com.so.authservice.exception;

import io.jsonwebtoken.ExpiredJwtException;

public class TokenExpirationException extends RuntimeException {

    public TokenExpirationException(String message, ExpiredJwtException exception) {
        super(message, exception);
    }
}
