package com.example.store.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.ACCEPTED)
public class UserAreReg extends RuntimeException{
    public UserAreReg(String message){
        super(message);
    }
}
