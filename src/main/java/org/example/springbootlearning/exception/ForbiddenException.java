package org.example.springbootlearning.exception;

public class ForbiddenException extends RuntimeException {
    public ForbiddenException(){
        super("Forbidden Exception!!");
    }
}
