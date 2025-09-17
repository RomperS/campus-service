package com.olo.campusservice.domain.exception.exists;

import com.olo.campusservice.domain.exception.base.ConflicDomainException;

public class CampusResourceExistsException extends ConflicDomainException {
    public CampusResourceExistsException(String message) {
        super(message);
    }

    public CampusResourceExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
