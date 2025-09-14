package com.olo.campusservice.domain.exception.exists;

import com.olo.campusservice.domain.exception.DomainException;

public class CampusResourceNotFoundException extends DomainException {
    public CampusResourceNotFoundException(String message) {
        super(message);
    }

    public CampusResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
