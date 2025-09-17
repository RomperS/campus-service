package com.olo.campusservice.domain.exception.exists;

import com.olo.campusservice.domain.exception.base.ConflicDomainException;

public class ResourceNameTakenException extends ConflicDomainException {
    public ResourceNameTakenException(String message) {
        super(message);
    }

    public ResourceNameTakenException(String message, Throwable cause) {
        super(message, cause);
    }
}
