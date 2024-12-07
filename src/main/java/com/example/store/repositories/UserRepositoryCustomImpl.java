package com.example.store.repositories;

import com.example.store.entities.UserStore;
import com.example.store.exceptions.NotFoundUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryCustomImpl {
    /**
     * Репозиторий
     */
    @Autowired
    private UserRepository _userRepository;

    @SuppressWarnings("unused")
    public UserStore findBy_login(String _login) {
        Iterable<UserStore> lst = _userRepository.findAll();
        for (var i: lst){
            if (i.getLogin().equals(_login)){
                return i;
            };
        }
        return null;
    }

}
