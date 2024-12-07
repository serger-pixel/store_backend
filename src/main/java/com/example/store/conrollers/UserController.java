package com.example.store.conrollers;

import com.example.store.entities.UserStore;
import com.example.store.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class UserController {
    /**
     * Сервис для обслуживания UserStore
     */
    @Autowired
    private UserService _service;

    /**
     * Метод регистрирования пользователя
     * @param user данные о пользователе
     * @return ифнормацию о регистрации
     */
    @PostMapping(value="users/reg")
    @ResponseStatus
    public ResponseEntity<UserStore> regUser(@RequestBody UserStore user){
        return ResponseEntity.created(URI.create("/post")).body(_service.regUser(user));
    }

    /**
     * Метод входа пользователя
     * @param login логин пользователя
     * @return ифнормацию о входе
     */
    @GetMapping(value="users/{login}")
    @ResponseStatus
    public  ResponseEntity<UserStore> getUser(@PathVariable(value = "login") String login){
        return ResponseEntity.ok().body(_service.getUser(login));
    }

    /**
     * Метод добавления товара в избарнное
     * @param login логин пользователя
     *
     */
    @PutMapping(value="user/{login}/take/product/{idProduct}")
    @ResponseStatus
    public void addFavorite(@RequestParam String login, @RequestParam int idProduct){
        _service.addFavorite(login, idProduct);
    }

    @DeleteMapping(value="user/{login}/delete/product/{idProduct}")
    @ResponseStatus
    public void deleteFavorite(@RequestParam String login, @RequestParam int idProduct){
        _service.deleteFavorite(login, idProduct);
    }
}
