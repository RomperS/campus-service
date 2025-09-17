package com.olo.campusservice.domain.exception.value;

import com.olo.campusservice.domain.exception.DomainException;

public class InvalidDescriptionValueException extends DomainException {
    public InvalidDescriptionValueException(String message) {
        super(message);
    }

    public InvalidDescriptionValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
