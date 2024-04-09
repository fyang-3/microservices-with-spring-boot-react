package com.mosesomondi.departmentservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentException {
    private LocalDateTime timestamp;
    private String message;
    private String path;
    private HttpStatus httpStatus;
    private Throwable throwable;
}
