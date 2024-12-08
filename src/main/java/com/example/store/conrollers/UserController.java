package com.example.store.conrollers;

import com.example.store.entities.UserStore;
import com.example.store.exceptions.NotFoundUserException;
import com.example.store.exceptions.NotIDentificationUserException;
import com.example.store.exceptions.UserAreReg;
import com.example.store.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
     * Сообщение о том, что пользователя не существует
     */
    private static final String _NotFoundUserMess = "Такого пользователя не существует";

    private static final String _NotIdentifiedUserMess = "Неправильный пароль";

    private static final String _UserAreRegMess = "Пользователь уже зарегестрирован";

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
        throw new UserAreReg(_UserAreRegMess);
    }

    /**
     * Метод входа пользователя
     * @param login логин пользователя
     * @return ифнормацию о входе
     */
    @GetMapping(value="users/signin/{login}/{password}")
    public  ResponseEntity<UserStore> getUser(@PathVariable(value = "login")  String login,
                                              @PathVariable(value = "password") String password){
        UserStore localUser = _service.getUser(login);
        if (localUser == null) {
            throw new NotFoundUserException(_NotFoundUserMess);
        }
        if (!localUser.getPassword().equals(password)){
            throw new NotIDentificationUserException(_NotIdentifiedUserMess);
        }
        //return ResponseEntity.ok().body(localUser);
        return ResponseEntity.ok().body(localUser);
    }

    /**
     * Метод добавления товара в избарнное
     * @param login логин пользователя
     *
     */
    @PutMapping(value="users/{login}/take/product/{idProduct}")
    public void addFavorite(@PathVariable(value = "login") String login,
                            @PathVariable(value="idProduct") int idProduct){
        UserStore localUser = _service.getUser(login);
        if (localUser == null) {
            throw new NotFoundUserException(_NotFoundUserMess);
        }
        _service.addFavorite(login, idProduct);
    }

    @DeleteMapping(value="users/{login}/delete/product/{idProduct}")
    public void deleteFavorite(@PathVariable(value = "login") String login,
                               @PathVariable(value="idProduct") int idProduct){
        UserStore localUser = _service.getUser(login);
        if (localUser == null) {
            throw new NotFoundUserException(_NotFoundUserMess);
        }
        _service.deleteFavorite(login, idProduct);
    }
}
