package com.olo.campusservice.domain.exception.base;

public class NotFoundDomainException extends DomainException{
    public NotFoundDomainException(String message) {
        super(message);
    }

    public NotFoundDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
