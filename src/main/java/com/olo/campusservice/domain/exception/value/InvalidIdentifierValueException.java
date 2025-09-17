package com.olo.campusservice.domain.exception.value;

import com.olo.campusservice.domain.exception.base.InvalidDomainValueException;

public class InvalidIdentifierValueException extends InvalidDomainValueException {
    public InvalidIdentifierValueException(String message) {
        super(message);
    }

    public InvalidIdentifierValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
