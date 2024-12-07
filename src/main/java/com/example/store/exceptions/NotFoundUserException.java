package com.example.store.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Такого пользователя не существует")
public class NotFoundUserException extends RuntimeException {
}