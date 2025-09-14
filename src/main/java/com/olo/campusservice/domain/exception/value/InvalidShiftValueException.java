package com.olo.campusservice.domain.exception.value;

import com.olo.campusservice.domain.exception.DomainException;

public class InvalidShiftValueException extends DomainException {
    public InvalidShiftValueException(String message) {
        super(message);
    }

    public InvalidShiftValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
