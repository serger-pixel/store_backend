package com.example.store.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Класс исключения ещё не зарегестрированного пользователя
 */
@ResponseStatus(value = HttpStatus.ACCEPTED)
public class NotIDentificationUserException extends RuntimeException{
    /**
     * Конструктор
     * @param message сообщение
     */
    public NotIDentificationUserException(String message){
        super(message);
    }
}
