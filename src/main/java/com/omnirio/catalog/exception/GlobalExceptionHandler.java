package com.omnirio.catalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // returning map, and handling generic exception in real app a error resource can be created
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleCategoryNotFoundException(Exception ex) {
        return Collections.singletonMap("error", ex.getMessage());
    }

}
