package com.example.store.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Класс исключения уже зарегестрированного пользователя
 */
@ResponseStatus(value= HttpStatus.ACCEPTED)
public class UserAreReg extends RuntimeException{
    /**
     * Конструктор
     * @param message сообщение
     */
    public UserAreReg(String message){
        super(message);
    }
}
