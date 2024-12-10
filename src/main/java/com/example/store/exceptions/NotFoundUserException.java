package com.example.store.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Класс исключения "Пользователь не найден"
 */
@ResponseStatus(value = HttpStatus.ACCEPTED)
public class NotFoundUserException extends RuntimeException {
    /**
     * Конструктор
     * @param message сообщение
     */
    public NotFoundUserException(String message){
        super(message);
    }
}