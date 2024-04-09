package com.mosesomondi.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {EmployeeNotFoundException.class})
    public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException exception, WebRequest webRequest) {

        EmployeeException employeeException = new EmployeeException(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                exception.getCause()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(employeeException);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleEmployeeGlobalException(Exception exception, WebRequest webRequest) {

        EmployeeException employeeGlobalException = new EmployeeException(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                exception.getCause()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(employeeGlobalException);
    }
}
