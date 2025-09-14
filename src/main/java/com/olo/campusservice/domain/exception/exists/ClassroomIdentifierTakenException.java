package com.olo.campusservice.domain.exception.exists;

import com.olo.campusservice.domain.exception.DomainException;

public class ClassroomIdentifierTakenException extends DomainException {
    public ClassroomIdentifierTakenException(String message) {
        super(message);
    }

    public ClassroomIdentifierTakenException(String message, Throwable cause) {
        super(message, cause);
    }
}
