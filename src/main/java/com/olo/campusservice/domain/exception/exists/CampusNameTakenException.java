package com.olo.campusservice.domain.exception.exists;

import com.olo.campusservice.domain.exception.base.ConflicDomainException;

public class CampusNameTakenException extends ConflicDomainException {
    public CampusNameTakenException(String message) {
        super(message);
    }

    public CampusNameTakenException(String message, Throwable cause) {
        super(message, cause);
    }
}
