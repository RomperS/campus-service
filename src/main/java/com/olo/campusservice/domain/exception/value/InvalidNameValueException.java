package com.olo.campusservice.domain.exception.value;

import com.olo.campusservice.domain.exception.DomainException;

public class InvalidNameValueException extends DomainException {
    public InvalidNameValueException(String message) {
        super(message);
    }

    public InvalidNameValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
