package com.example.store.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ACCEPTED)
public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException(String message){
        super(message);
    }
}