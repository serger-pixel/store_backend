package com.example.store.services;

import com.example.store.entities.UserStore;
import com.example.store.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EditUsersService {
    @Autowired
    private UserRepository _userRepository;

    public Iterable<UserStore> getAllUsers(int id){
        ArrayList<UserStore> localMass = new ArrayList<>();
        Iterable<UserStore> users = _userRepository.findAll();
        for (var user: users){
            if (user.getId() == id){
                continue;
            }
            localMass.add(user);
        }
        return localMass;
    }

    public void deleteUser(int id){
        _userRepository.deleteById(id);
    }

    public UserStore addUser(UserStore user){
        return _userRepository.save(user);
    }

}
