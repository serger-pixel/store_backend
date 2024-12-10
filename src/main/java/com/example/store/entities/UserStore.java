package com.example.store.entities;

import com.example.store.services.UserService;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
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
    @Column
    private int _id;

    @Column
    private String _login;

    @Column
    private String _password;

    @Column
    private int[] _favorites = new int[UserService._defaultLen];

    @Column
    private String _role = UserService._defaultRole;

    @Column
    private int _idImage = UserService._defaultImageId;

    @Column
    private int _cntLog = UserService._defaultCntLog;


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

    public int getIdImage(){
        return _idImage;
    }

    public int[] getFavorites() {
        int[] localMass = new int[_favorites.length];
        for(int i =0; i < _favorites.length; i++){
            localMass[i] = _favorites[i];
        }
        return localMass;
    }

    public String getRole(){
        return _role;
    }

    public int getCntLog(){
        return _cntLog;
    }

    public void setCntLog(int cntLog){
        _cntLog = cntLog;
    }

    public void setIdImage(int idImage){
        _idImage = idImage;
    }

    public void setId(int id) {
        _id = id;
    }

    public void setRole(String role){
        _role = role;
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
