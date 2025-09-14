package com.olo.campusservice.domain.exception.exists;

import com.olo.campusservice.domain.exception.DomainException;

public class ClassroomNotFoundException extends DomainException {
    public ClassroomNotFoundException(String message) {
        super(message);
    }

    public ClassroomNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
