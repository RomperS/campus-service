package com.olo.campusservice.domain.exception.value;

import com.olo.campusservice.domain.exception.DomainException;

public class InvalidIdentifierValueException extends DomainException {
    public InvalidIdentifierValueException(String message) {
        super(message);
    }

    public InvalidIdentifierValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
