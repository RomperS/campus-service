package com.olo.campusservice.domain.exception.not_found;

import com.olo.campusservice.domain.exception.base.NotFoundDomainException;

public class ClassroomNotFoundException extends NotFoundDomainException {
    public ClassroomNotFoundException(String message) {
        super(message);
    }

    public ClassroomNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
