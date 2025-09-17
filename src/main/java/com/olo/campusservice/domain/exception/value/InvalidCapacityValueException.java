package com.olo.campusservice.domain.exception.value;

import com.olo.campusservice.domain.exception.base.InvalidDomainValueException;

public class InvalidCapacityValueException extends InvalidDomainValueException {
    public InvalidCapacityValueException(String message) {
        super(message);
    }

    public InvalidCapacityValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
