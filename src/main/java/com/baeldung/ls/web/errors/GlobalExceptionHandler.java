package com.baeldung.ls.web.errors;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// ResponseEntityExceptionHandler already handles a lot of common exceptions, can be customized
// Adheres to "Problem Details for HTTP APIs" (RFC 7807) specification
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // Would be better to return an object with more details. Right now the nice JSON structure is lost
    // Multiple exceptions can be handled in the same method
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
        return new ResponseEntity<>("Exception retrieving data: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
