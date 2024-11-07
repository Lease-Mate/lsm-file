package com.lsm.ws.file.configuration.exception.unauthorized;

public class JwtAuthenticationException extends UnauthorizedException {

    public JwtAuthenticationException(String message) {
        super(message);
    }
}
