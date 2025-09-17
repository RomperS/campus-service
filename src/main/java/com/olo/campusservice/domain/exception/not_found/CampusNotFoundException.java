package com.olo.campusservice.domain.exception.not_found;

import com.olo.campusservice.domain.exception.base.NotFoundDomainException;

public class CampusNotFoundException extends NotFoundDomainException {
    public CampusNotFoundException(String message) {
        super(message);
    }

    public CampusNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
