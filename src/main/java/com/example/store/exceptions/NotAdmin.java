package com.example.store.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Класс исключения "Пользователь не администратор"
 */
@ResponseStatus(value = HttpStatus.ACCEPTED)
public class NotAdmin extends RuntimeException {
    /**
     * Конструктор
     * @param message сообщение
     */
    public NotAdmin(String message) {
        super(message);
    }
}
