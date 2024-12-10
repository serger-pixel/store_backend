package com.example.store.conrollers;

import com.example.store.entities.UserStore;
import com.example.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.Date;

@RestController
public class MainPageController {
    @Autowired
    UserService _service;

    @GetMapping(value="/get/cnt")
    public int getCnt(){
        Iterable<UserStore> lstUser = _service.getAll();
        int cnt = 0;
        for(var i: lstUser){
            cnt+=i.getCntLog();
        }
        return cnt;
    }

    @GetMapping(value="/get/time")
    public String getTime(){
        return (new Date()).toString();
    }
}
