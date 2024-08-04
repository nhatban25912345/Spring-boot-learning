package org.example.springbootlearning.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnAuthorizationException extends RuntimeException {
    public UnAuthorizationException(){
        super("Unauthorized!!");
    }
}
