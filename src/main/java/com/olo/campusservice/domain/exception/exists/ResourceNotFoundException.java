package com.olo.campusservice.domain.exception.exists;

import com.olo.campusservice.domain.exception.DomainException;

public class ResourceNotFoundException extends DomainException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
