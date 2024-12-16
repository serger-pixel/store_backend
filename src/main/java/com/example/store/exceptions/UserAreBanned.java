package com.example.store.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ACCEPTED)
public class UserAreBanned extends RuntimeException{
    public UserAreBanned(String message){
        super(message);
    }
}
