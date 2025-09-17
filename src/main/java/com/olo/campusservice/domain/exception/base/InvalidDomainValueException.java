package com.olo.campusservice.domain.exception.base;

public class InvalidDomainValueException extends DomainException {
    public InvalidDomainValueException(String message) {
        super(message);
    }

    public InvalidDomainValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
