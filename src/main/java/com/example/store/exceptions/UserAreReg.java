package com.example.store.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT,reason = "Пользователь уже зарегестрирован")
public class UserAreReg extends RuntimeException{
}
