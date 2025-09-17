package com.olo.campusservice.domain.exception.not_found;

import com.olo.campusservice.domain.exception.base.NotFoundDomainException;

public class ResourceNotFoundException extends NotFoundDomainException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
