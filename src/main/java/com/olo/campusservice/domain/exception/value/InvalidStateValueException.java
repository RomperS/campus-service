package com.olo.campusservice.domain.exception.value;

import com.olo.campusservice.domain.exception.DomainException;

public class InvalidStateValueException extends DomainException {
    public InvalidStateValueException(String message) {
        super(message);
    }

    public InvalidStateValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
