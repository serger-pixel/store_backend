package com.example.store.conrollers;

import com.example.store.entities.UserStore;
import com.example.store.exceptions.NotFoundUserException;
import com.example.store.exceptions.UserAreReg;
import com.example.store.services.UserService;
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
    public ResponseEntity<UserStore> regUser(@RequestBody UserStore user){
        if(_service.getUser(user.getLogin()) == null){
            return ResponseEntity.ok().body(_service.regUser(user));
        }
        throw new UserAreReg();
    }

    /**
     * Метод входа пользователя
     * @param login логин пользователя
     * @return ифнормацию о входе
     */
    @GetMapping(value="users/signin")
    @ResponseStatus
    public  ResponseEntity<UserStore> getUser(@RequestParam String login,
                                              @RequestParam String password){
        UserStore localUser = _service.getUser(login);
        if (localUser == null) {
            throw new NotFoundUserException();
        }
        if (!localUser.getPassword().equals(password)){
            throw new NotFoundUserException();
        }
        return ResponseEntity.ok().body(localUser);
    }

    /**
     * Метод добавления товара в избарнное
     * @param login логин пользователя
     *
     */
    @PutMapping(value="users/{login}/take/product/{idProduct}")
    @ResponseStatus
    public void addFavorite(@PathVariable(value = "login") String login,
                            @PathVariable(value="idProduct") int idProduct){
        UserStore localUser = _service.getUser(login);
        if (localUser == null) {
            throw new NotFoundUserException();
        }
        _service.addFavorite(login, idProduct);
    }

    @DeleteMapping(value="users/{login}/delete/product/{idProduct}")
    @ResponseStatus
    public void deleteFavorite(@PathVariable(value = "login") String login,
                               @PathVariable(value="idProduct") int idProduct){
        UserStore localUser = _service.getUser(login);
        if (localUser == null) {
            throw new NotFoundUserException();
        }
        _service.deleteFavorite(login, idProduct);
    }
}
