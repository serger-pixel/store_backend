package com.example.store.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ACCEPTED)
public class NotIDentificationUserException extends RuntimeException{
    public NotIDentificationUserException(String message){
        super(message);
    }
}
