package com.example.store.repositories;

import com.example.store.entities.UserStore;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserStore, Integer> {
    UserStore findBy_login(String login);
}
