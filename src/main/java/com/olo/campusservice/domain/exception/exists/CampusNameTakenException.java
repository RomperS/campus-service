package com.olo.campusservice.domain.exception.exists;

import com.olo.campusservice.domain.exception.DomainException;

public class CampusNameTakenException extends DomainException {
    public CampusNameTakenException(String message) {
        super(message);
    }

    public CampusNameTakenException(String message, Throwable cause) {
        super(message, cause);
    }
}
