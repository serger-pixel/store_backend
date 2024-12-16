package com.example.store.services;

import com.example.store.entities.UserStore;
import com.example.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminService {
    @Autowired
    public UserRepository _userRepository;

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

    public void deleteUser(int id){
        _userRepository.deleteById(id);
    }

    public UserStore addUser(UserStore user){
        return _userRepository.save(user);
    }

    public void setRole(int id, String role){
        UserStore user = _userRepository.findById(id).get();
        user.setRole(role);
        _userRepository.save(user);
    }

    public void setUserStatus(int id, String status){
        UserStore user = _userRepository.findById(id).get();
        user.setStatus(status);
        _userRepository.save(user);
    }
}
