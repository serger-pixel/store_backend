package com.example.store.services;


import com.example.store.entities.UserStore;
import com.example.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Класс-сервис для пользователя
 */
@Service
public class UserService {
    /**
     * Репозиторий пользователей
     */
    @Autowired
    public UserRepository _userRepository;

    /**
     * Роль по умолчанию
     */
    public final static String _defaultRole = "User";

    /**
     * Длина списка избранных товаров по умолчанию
     */
    public final static int _defaultLen = 0;

    /**
     * Идентификатор изображения по умолчанию
     */
    public final static int _defaultImageId = 26;

    /**
     * Кол-во посещений по умолчанию
     */
    public final static int _defaultCntLog = 1;

    public final static String _defaultStatus = "unbanned";

    /**
     * Сохранение пользователя в базе данных
     * @param user пользователь
     * @return экземпляр сохранённой сущности
     */
    public UserStore regUser(UserStore user){
        return _userRepository.save(user);
    }

    /**
     * Получение пользователя из базы данных
     * @param login логин
     * @return пользователь
     */
    public UserStore getUser(String login){
        return _userRepository.findBy_login(login);
    }

    /**
     * Получение всех пользователей из базы данных
     * @return список всех пользователей
     */
    public Iterable<UserStore> getAll(){
        return _userRepository.findAll();
    }

    /**
     * Получение всех избранных товаров пользователя
     * @param login логин
     * @return список избранных товаров
     */
    public int[] getFavorites(String login){
        return _userRepository.findBy_login(login).getFavorites();
    }

    /**
     * Добавление товара в избранное
     * @param login логин пользователя
     * @param idProduct id товара, который добавляется
     */
    public void addFavorite(String login, int idProduct){
        UserStore user = _userRepository.findBy_login(login);
        int len = user.getFavorites().length;
        int [] favorites = user.getFavorites();
        int [] localMass =  new int[len + 1];
        for (int i = 0; i < len; i++){
            localMass[i] = favorites[i];
        }
        localMass[len] = idProduct;
        user.setFavorites(localMass);
        _userRepository.save(user);
    }

    /**
     * Удаление товара из избранного
     * @param login логин пользователя
     * @param idProduct id товара, который удаляется
     */
    public void deleteFavorite(String login, int idProduct){
        UserStore user = _userRepository.findBy_login(login);
        int len = user.getFavorites().length;
        int [] favorites = user.getFavorites();
        int [] localMass = new int[len - 1];
        int indLocalMass = 0;
        for (int i =0; i < len; i++){
            if (favorites[i] == idProduct){
                continue;
            }
            localMass[indLocalMass] = favorites[i];
            indLocalMass++;
        }
        user.setFavorites(localMass);
        _userRepository.save(user);
    }

    /**
     * Установка изображения (аватара)
     * @param login логин пользователя
     * @param idProduct идентификатор изображения
     */
    public void setImage(String login, int idProduct){
        UserStore user = _userRepository.findBy_login(login);
        user.setIdImage(idProduct);
        _userRepository.save(user);
    }
}

