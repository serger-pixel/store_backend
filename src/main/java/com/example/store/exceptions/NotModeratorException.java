package com.example.store.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Класс исключения пользователя, не являющегося модератором
 */
@ResponseStatus(value= HttpStatus.ACCEPTED)
public class NotModeratorException extends RuntimeException {

    /**
     * Конструктор
     * @param message сообщение
     */
    public NotModeratorException(String message) {
        super(message);
    }
}
