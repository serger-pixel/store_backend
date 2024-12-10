package com.example.store.conrollers;

import com.example.store.entities.UserStore;
import com.example.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Класс-контроллер главной страницы
 */
@RestController
public class MainPageController {
    /**
     * Сервис пользователя
     */
    @Autowired
    UserService _service;

    /**
     * Получение счётчика посещений
     * @return счётчик посещений
     */
    @GetMapping(value="/get/cnt")
    public int getCnt(){
        Iterable<UserStore> lstUser = _service.getAll();
        int cnt = 0;
        for(var i: lstUser){
            cnt+=i.getCntLog();
        }
        return cnt;
    }

    /**
     * Получение текущей даты и времени
     * @return текущая дата и время
     */
    @GetMapping(value="/get/time")
    public String getTime(){
        return (new Date()).toString();
    }
}
