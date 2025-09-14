package com.olo.campusservice.domain.exception.exists;

import com.olo.campusservice.domain.exception.DomainException;

public class CampusResourceExistsException extends DomainException {
    public CampusResourceExistsException(String message) {
        super(message);
    }

    public CampusResourceExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
