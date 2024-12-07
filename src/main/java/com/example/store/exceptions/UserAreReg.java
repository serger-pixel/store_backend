package com.example.store.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Пользователь уже зарегестрирован")
public class UserAreReg extends RuntimeException{
}
