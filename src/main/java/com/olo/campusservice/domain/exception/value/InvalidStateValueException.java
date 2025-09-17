package com.olo.campusservice.domain.exception.value;

import com.olo.campusservice.domain.exception.base.InvalidDomainValueException;

public class InvalidStateValueException extends InvalidDomainValueException {
    public InvalidStateValueException(String message) {
        super(message);
    }

    public InvalidStateValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
