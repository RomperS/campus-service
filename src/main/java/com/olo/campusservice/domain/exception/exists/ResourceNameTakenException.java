package com.olo.campusservice.domain.exception.exists;

import com.olo.campusservice.domain.exception.DomainException;

public class ResourceNameTakenException extends DomainException {
    public ResourceNameTakenException(String message) {
        super(message);
    }

    public ResourceNameTakenException(String message, Throwable cause) {
        super(message, cause);
    }
}
