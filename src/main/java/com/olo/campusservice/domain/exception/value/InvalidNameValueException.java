package com.olo.campusservice.domain.exception.value;

import com.olo.campusservice.domain.exception.base.InvalidDomainValueException;

public class InvalidNameValueException extends InvalidDomainValueException {
    public InvalidNameValueException(String message) {
        super(message);
    }

    public InvalidNameValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
