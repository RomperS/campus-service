package com.olo.campusservice.domain.exception.exists;

import com.olo.campusservice.domain.exception.base.ConflicDomainException;

public class ClassroomIdentifierTakenException extends ConflicDomainException {
    public ClassroomIdentifierTakenException(String message) {
        super(message);
    }

    public ClassroomIdentifierTakenException(String message, Throwable cause) {
        super(message, cause);
    }
}
