package com.example.store.conrollers;

import com.example.store.entities.UserStore;
import com.example.store.exceptions.NotAdmin;
import com.example.store.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.store.services.UserService._NotAccess;
import static com.example.store.services.UserService._adminRole;

@RestController
public class AdminController {
    /**
     * Сервис для работы c администратором
     */
    @Autowired
    public AdminService _service;

    /**
     * Получение всех пользователей из базы данных
     * @param userLogin логин пользователя, который запрашивает всех пользователей
     * @return возвращает список пользователей
     */
    @GetMapping(value = "users/{login}/get/all")
    public ResponseEntity<Iterable<UserStore>> getAllUsers(@PathVariable(value = "login") String userLogin){
        UserStore user = _service._userRepository.findBy_login(userLogin);
        if (user.getRole().equals(_adminRole)) {
            return ResponseEntity.ok().body(_service.getAllUsers(userLogin));
        }
        throw new NotAdmin(_NotAccess);
    }

    /**
     * Добавление пользователя в базу данных
     * @param userLogin логин пользователя, который добавляет другого пользователя
     * @param user банные о пользователе, которого добавляют
     * @return добавленный пользователь
     */
    @PostMapping(value = "users/{login}/post")
    public ResponseEntity<UserStore> addUser(@PathVariable(value = "login") String userLogin,
                                             @RequestBody UserStore user){
        UserStore localUser = _service._userRepository.findBy_login(userLogin);
        if (localUser.getRole().equals(_adminRole)) {
            return ResponseEntity.ok().body(_service.addUser(user));
        }
        throw new NotAdmin(_NotAccess);
    }

    /**
     * Удаление пользователя из базы данных
     * @param userLogin логин пользователя, который удаляет другого пользователя
     * @param id идентификатор пользователя, которого удаляют
     */
    @DeleteMapping(value ="users/{login}/delete/{id}")
    public void deleteUser(@PathVariable(value = "login") String userLogin,
                           @PathVariable(value = "id") String id){
        UserStore localUser = _service._userRepository.findBy_login(userLogin);
        if (localUser.getRole().equals(_adminRole)) {
            _service.deleteUser(Integer.parseInt(id));
        }
        throw new NotAdmin(_NotAccess);
    }

    /**
     * Установка роли для пользователя
     * @param userLogin логин пользователя, который изменяет роль другого пользователя
     * @param id идентификатор пользователя, у которого меняют роль
     * @param role роль
     */
    @PutMapping(value="users/{login}/editrole/{id}/{role}")
    public void setRole(@PathVariable(value="login") String userLogin,
                        @PathVariable(value = "id") String id,
                        @PathVariable(value = "role") String role){
        UserStore localUser = _service._userRepository.findBy_login(userLogin);
        if (localUser.getRole().equals(_adminRole)){
            _service.setRole(Integer.parseInt(id), role);
        }
        throw new NotAdmin(_NotAccess);
    }

    /**
     * Установка статуса для пользователя
     * @param userLogin логин пользователя, который изменяет статус другого пользователя
     * @param id идентификатор пользователя, у которого меняют статус
     * @param status статус
     */
    @PutMapping(value="users/{login}/setuserstatus/{id}/{status}")
    public void setUserStatus(@PathVariable(value="login") String userLogin,
                              @PathVariable(value = "id") String id,
                              @PathVariable(value = "status") String status){
        UserStore localUser = _service._userRepository.findBy_login(userLogin);
        if (localUser.getRole().equals(_adminRole)){
            _service.setUserStatus(Integer.parseInt(id), status);
        }
        throw new NotAdmin(_NotAccess);
    }
}
