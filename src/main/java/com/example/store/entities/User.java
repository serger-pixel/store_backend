package com.example.store.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.ArrayList;

public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int _id;

    private String _login;

    private String _password;

    private ArrayList<Item> _favorites;

    public User(String password, String login) {
        this._favorites = new ArrayList<Item>();
        this._password = password;
        this._login = login;
    }

    public int getId() {
        return _id;
    }

    public String getLogin() {
        return _login;
    }

    public String getPassword() {
        return _password;
    }

    public ArrayList<Item> getFavorites() {
        return _favorites;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public void setLogin(String _login) {
        this._login = _login;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public void addFavorite(Item el){
        _favorites.add(el);
    }

    public void deleteFavorite(Item el){
        _favorites.remove(el);
    }
}
