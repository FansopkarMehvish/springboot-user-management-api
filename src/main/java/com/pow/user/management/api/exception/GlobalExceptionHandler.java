package com.pow.user.management.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    private ResponseEntity<String> handleEmailAlreadyExistsException(EmailAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(exception.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {

        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error ->
                        errors.put(error.getField(), error.getDefaultMessage())
                );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }
}
