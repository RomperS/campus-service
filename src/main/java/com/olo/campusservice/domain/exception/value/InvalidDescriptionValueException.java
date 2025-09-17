package com.olo.campusservice.domain.exception.value;

import com.olo.campusservice.domain.exception.base.InvalidDomainValueException;

public class InvalidDescriptionValueException extends InvalidDomainValueException {
    public InvalidDescriptionValueException(String message) {
        super(message);
    }

    public InvalidDescriptionValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
