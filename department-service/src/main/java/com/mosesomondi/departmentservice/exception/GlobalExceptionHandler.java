package com.mosesomondi.departmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {DepartmentNotFoundException.class})
    public ResponseEntity<Object> handleDepartmentNotFound(DepartmentNotFoundException exception, WebRequest webRequest) {
        DepartmentException departmentException = new DepartmentException(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                exception.getCause()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(departmentException);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleGlobalException(Exception exception, WebRequest webRequest) {
        DepartmentException departmentGlobalException = new DepartmentException(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getCause()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(departmentGlobalException);
    }
}
