package com.example.store.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.ACCEPTED)
public class NotModeratorException extends RuntimeException {

    public NotModeratorException(String message) {
        super(message);
    }
}
