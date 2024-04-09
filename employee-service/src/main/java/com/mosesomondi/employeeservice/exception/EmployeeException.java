package com.mosesomondi.employeeservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeException {
    private LocalDateTime timestamp;
    private String message;
    private String path;
    private HttpStatus httpStatus;
    private Throwable throwable;
}
