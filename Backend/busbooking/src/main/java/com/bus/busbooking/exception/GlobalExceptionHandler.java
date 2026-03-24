package com.bus.busbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice  //This annotation is used to handle exceptions globally in a Spring Boot application. It allows you to

public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class) 
    public Map<String, String> handleUserNotFoundException(UserNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        error.put("status", HttpStatus.NOT_FOUND.toString());
        return error;
    }

}
