package com.example.store.entities;

import com.example.store.services.UserService;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

@Entity
@Table
@DynamicInsert
@NoArgsConstructor
public class UserStore {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int _id;

    private String _login;

    private String _password;

    private int[] _favorites = new int[UserService._defaultLen];

    private String _role = UserService._defaultRole;

    private int _idImage;


    public UserStore(String password, String login) {
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

    public int[] getFavorites() {
        int[] localMass = new int[_favorites.length];
        for(int i =0; i < _favorites.length; i++){
            localMass[i] = _favorites[i];
        }
        return localMass;
    }

    public void setId(int id) {
        _id = id;
    }

    public void setRole(String role){
        _role = role;
    }

    public String getRole(){
        return _role;
    }

    public void setLogin(String login) {
        _login = login;
    }

    public void setPassword(String password) {
        _password = password;
    }

    public void setFavorites(int[] favorites){
        _favorites = favorites;
    }
}
