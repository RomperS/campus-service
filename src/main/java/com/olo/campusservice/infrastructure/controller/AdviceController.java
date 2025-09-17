package com.olo.campusservice.infrastructure.controller;

import com.olo.campusservice.domain.exception.base.ConflicDomainException;
import com.olo.campusservice.domain.exception.base.DomainException;
import com.olo.campusservice.domain.exception.base.InvalidDomainValueException;
import com.olo.campusservice.domain.exception.base.NotFoundDomainException;
import com.olo.campusservice.infrastructure.util.ExceptionResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
@RequiredArgsConstructor
public class AdviceController {

    private final ExceptionResponseUtil exceptionResponseUtil;

    @ExceptionHandler(DomainException.class)
    public void handleDomainException(DomainException ex, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpStatus status;

        if (ex instanceof InvalidDomainValueException) {
            status = HttpStatus.BAD_REQUEST;
        } else if (ex instanceof ConflicDomainException) {
            status = HttpStatus.CONFLICT;
        } else if (ex instanceof NotFoundDomainException) {
            status = HttpStatus.NOT_FOUND;
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        exceptionResponseUtil.writeErrorResponse(response, status, ex.getClass().getSimpleName(), ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void handledDomainException(MethodArgumentNotValidException ex, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        exceptionResponseUtil.writeErrorResponse(response, status, ex.getClass().getSimpleName(), ex.getMessage(), request.getRequestURI());
    }
}