package org.example.springbootlearning.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    // Constructor that accepts a custom message
    public ResourceNotFoundException(String message) {
        super("Not found data: " + message);
    }

    // Default constructor with a default message
    public ResourceNotFoundException() {
        super("Not found data");
    }
}
