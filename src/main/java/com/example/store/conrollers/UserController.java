package com.example.store.conrollers;

import com.example.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService _service;

    @PutMapping(value="user/{idUser}/take/product/{idProduct}")
    public void addFavorite(@RequestParam int idUser, @RequestParam int idProduct){
        _service.addFavorite(idUser, idProduct);
    }

    @DeleteMapping(value="user/{idUser}/delete/product/{idProduct}")
    public void deleteFavvorite(@RequestParam int idUser, @RequestParam int idProduct){
        _service.deleteFavorite(idUser, idProduct);
    }
}
