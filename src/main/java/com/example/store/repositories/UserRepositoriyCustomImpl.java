package com.example.store.repositories;

import com.example.store.entities.UserStore;
import com.example.store.exceptions.NotFoundUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
public class UserRepositoriyCustomImpl {
    /**
     * Запрос в базу данных для изменения избранных товаров
     */
    private static final String SQL_UPDATE_FAVORITIES =
            "update user_store set  _favorities = :favorities where id = :id";

    /**
     * Репозиторий
     */
    @Autowired
    private UserRepository _userRepository;

    @SuppressWarnings("unused")
    public UserStore findByLogin(String login) {
        Iterable<UserStore> lst = _userRepository.findAll();
        for (var i: lst){
            if (i.getLogin().equals(login)){
                return i;
            };
        }
        throw new NotFoundUserException();
    }

}
