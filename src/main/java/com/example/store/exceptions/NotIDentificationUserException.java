package com.example.store.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Неправильный пароль")
public class NotIDentificationUserException extends RuntimeException{
}
