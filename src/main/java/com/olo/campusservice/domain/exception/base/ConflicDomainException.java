package com.olo.campusservice.domain.exception.base;

public class ConflicDomainException extends DomainException {
    public ConflicDomainException(String message) {
        super(message);
    }

    public ConflicDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
