package com.example.store.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@Table
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int _id;

    private String _login;

    private String _password;

    private ArrayList<Integer> _favorites;

    private String _role;

    public User(String password, String login) {
        this._favorites = new ArrayList<Integer>();
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

    public ArrayList<Integer> getFavorites() {
        return _favorites;
    }

    public void setId(int id) {
        this._id = id;
    }

    public void setRole(String role){
        this._role = role;
    }

    public String getRole(){
        return _role;
    }

    public void setLogin(String _login) {
        this._login = _login;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public void addFavorite(int el){
        _favorites.add(el);
    }

    public void deleteFavorite(int el){
        _favorites.remove(el);
    }
}
