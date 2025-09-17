package com.olo.campusservice.domain.exception.value;

import com.olo.campusservice.domain.exception.base.InvalidDomainValueException;

public class InvalidQuantityException extends InvalidDomainValueException {
    public InvalidQuantityException(String message) {
        super(message);
    }

    public InvalidQuantityException(String message, Throwable cause) {
        super(message, cause);
    }
}
