package com.olo.campusservice.domain.exception.value;

import com.olo.campusservice.domain.exception.DomainException;

public class InvalidCapacityValueException extends DomainException {
    public InvalidCapacityValueException(String message) {
        super(message);
    }

    public InvalidCapacityValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
