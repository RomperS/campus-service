package com.olo.campusservice.domain.exception.base;

public class SecurityException extends RuntimeException {
    public SecurityException(String message) {
        super(message);
    }

    public SecurityException(String message, Throwable cause) {
        super(message, cause);
    }
}
