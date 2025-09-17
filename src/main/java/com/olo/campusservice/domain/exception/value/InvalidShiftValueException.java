package com.olo.campusservice.domain.exception.value;

import com.olo.campusservice.domain.exception.base.InvalidDomainValueException;

public class InvalidShiftValueException extends InvalidDomainValueException {
    public InvalidShiftValueException(String message) {
        super(message);
    }

    public InvalidShiftValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
