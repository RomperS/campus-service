package com.olo.campusservice.domain.exception.exists;

import com.olo.campusservice.domain.exception.DomainException;

public class CampusNotFoundException extends DomainException {
    public CampusNotFoundException(String message) {
        super(message);
    }

    public CampusNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
