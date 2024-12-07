package com.example.store.services;


import com.example.store.entities.UserStore;
import com.example.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private UserRepository _userRepository;

    public final static String _defaultRole = "User";

    public final static int _defaultLen = 1;

    public UserStore regUser(UserStore user){
        return _userRepository.save(user);
    }

    public UserStore getUser(String login){
        return _userRepository.findByLogin(login);
    }

    public int[] getFavorites(String login){
        return _userRepository.findByLogin(login).getFavorites();
    }

    /**
     * Добавление товара в избранное
     * @param login логин пользователя
     * @param idProduct id товара, который добавляется
     */
    public void addFavorite(String login, int idProduct){
        UserStore user = _userRepository.findByLogin(login);
        int len = user.getFavorites().length;
        int [] favorites = user.getFavorites();
        int [] localMass =  new int[len + 1];
        for (int i = 0; i < len; i++){
            localMass[i] = favorites[i];
        }
        localMass[len] = idProduct;
        user.setFavorites(localMass);
    }

    /**
     * Удаление товара из избранного
     * @param login логин пользователя
     * @param idProduct id товара, который удаляется
     */
    public void deleteFavorite(String login, int idProduct){
        UserStore user = _userRepository.findByLogin(login);
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
    }
}

