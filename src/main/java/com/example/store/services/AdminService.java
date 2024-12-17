package com.example.store.services;

import com.example.store.entities.UserStore;
import com.example.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * Класс-сервис для админа
 */
@Service
public class AdminService {
    /**
     * Репозиторий пользователей
     */
    @Autowired
    public UserRepository _userRepository;

    /**
     * Полученние всех пользователей за исключением текущего
     * @param userLogin логин текущего пользователя
     * @return список всех полльзователей
     */
    public Iterable<UserStore> getAllUsers(String userLogin){
        ArrayList<UserStore> localMass = new ArrayList<>();
        Iterable<UserStore> users = _userRepository.findAll();
        for (var user: users){
            if (user.getLogin().equals(userLogin)){
                continue;
            }
            localMass.add(user);
        }
        return localMass;
    }

    /**
     * Удаление пользователя по id
     * @param id - идентификатор полльзователя
     */
    public void deleteUser(int id){
        _userRepository.deleteById(id);
    }

    /**
     * Добавление пользователя
     * @param user данные о пользователе
     * @return добавленного пользователя
     */
    public UserStore addUser(UserStore user){
        return _userRepository.save(user);
    }

    /**
     * Установка роли пользователя
     * @param id идентификатор пользователя
     * @param role роль
     */
    public void setRole(int id, String role){
        UserStore user = _userRepository.findById(id).get();
        user.setRole(role);
        _userRepository.save(user);
    }

    /**
     * Установка статуса пользователя
     * @param id идентификатор пользователя
     * @param status статус
     */
    public void setUserStatus(int id, String status){
        UserStore user = _userRepository.findById(id).get();
        user.setStatus(status);
        _userRepository.save(user);
    }

    public void setLogin(int id, String login){
        UserStore user = _userRepository.findById(id).get();
        user.setLogin(login);
        _userRepository.save(user);
    }

    public void setPassword(int id, String password){
        UserStore user = _userRepository.findById(id).get();
        user.setPassword(password);
        _userRepository.save(user);
    }
}
