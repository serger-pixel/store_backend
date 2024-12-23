package com.example.store.conrollers;

import com.example.store.entities.UserStore;
import com.example.store.exceptions.NotFoundUserException;
import com.example.store.exceptions.NotIDentificationUserException;
import com.example.store.exceptions.UserAreBanned;
import com.example.store.exceptions.UserAreReg;
import com.example.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static com.example.store.services.UserService.*;

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
        if (localUser.getStatus().equals(_bannedStatus)){
            throw new UserAreBanned(_UserAreBan);
        }
        localUser.setCntLog(localUser.getCntLog()+1);
        _service._userRepository.save(localUser);
        return ResponseEntity.ok().body(localUser);
    }

    /**
     * Метод добавления товара в избранное
     * @param login логин пользователя
     *
     */
    @PutMapping(value="users/{login}/take/product/{idProduct}")
    public void addFavorite(@PathVariable(value = "login") String login,
                                                 @PathVariable(value="idProduct") int idProduct){
        UserStore localUser = _service.getUser(login);
        _service.addFavorite(login, idProduct);
    }

    /**
     * Удаление товара из избранного
     * @param login логин пользователя
     * @param idProduct идентификатор товара
     */
    @DeleteMapping(value="users/{login}/delete/product/{idProduct}")
    public void deleteFavorite(@PathVariable(value = "login") String login,
                                                    @PathVariable(value="idProduct") int idProduct){
        UserStore localUser = _service.getUser(login);
        _service.deleteFavorite(login, idProduct);
    }

    /**
     * Установка изображения
     * @param login логин пользователя
     * @param idImage идентификатор изображения
     */
    @PutMapping(value="users/{login}/set/product/image/{idImage}")
    public void setImage(@PathVariable(value = "login") String login,
                    @PathVariable(value="idImage") int idImage){
        UserStore localUser = _service.getUser(login);
        if (localUser.getIdImage() != _defaultImageId){
            _service._imageRepository.deleteById(localUser.getIdImage());
        }
        _service.setImage(login, idImage);
    }


}
