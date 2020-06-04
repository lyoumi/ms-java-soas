package com.so.authservice.exception;

import io.jsonwebtoken.SignatureException;

public class TokenValidationException extends RuntimeException {

    public TokenValidationException(String message) {
        super(message);
    }


    public TokenValidationException(String message, SignatureException exception) {
        super(message, exception);
    }
}
