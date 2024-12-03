package com.example.store.services;

import com.example.store.entities.Image;
import com.example.store.repositories.ImageRepository;
import com.example.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private UserRepository _userRepository;

    public ArrayList<Integer> getFavorites(int id){
        return _userRepository.findById(id).get().getFavorites();
    }

    public void addFavorite(int idUser, int idProduct){
        _userRepository.findById(idUser).get().addFavorite(idProduct);
    }

    public void deleteFavorite(int idUser, int idProduct){
        _userRepository.findById(idUser).get().deleteFavorite(idProduct);
    }
}

