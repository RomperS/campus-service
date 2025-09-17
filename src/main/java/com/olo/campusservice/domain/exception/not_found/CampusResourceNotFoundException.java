package com.olo.campusservice.domain.exception.not_found;

import com.olo.campusservice.domain.exception.base.NotFoundDomainException;

public class CampusResourceNotFoundException extends NotFoundDomainException {
    public CampusResourceNotFoundException(String message) {
        super(message);
    }

    public CampusResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
