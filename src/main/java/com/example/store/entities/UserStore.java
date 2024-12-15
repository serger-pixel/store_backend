package com.example.store.entities;

import com.example.store.services.UserService;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Класс-сущность пользователя
 */
@Entity
@Table
@DynamicInsert
@NoArgsConstructor
public class UserStore {
    /**
     * Идентификатор пользователя
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private int _id;

    /**
     * Логин
     */
    @Column
    private String _login;

    /**
     * Пароль
     */
    @Column
    private String _password;

    /**
     * Список избранных товаров
     */
    @Column
    private int[] _favorites = new int[UserService._defaultLen];

    /**
     * Роль
     */
    @Column
    private String _role = UserService._defaultRole;

    /**
     * Идентификатор изображения (аватар)
     */
    @Column
    private int _idImage = UserService._defaultImageId;

    /**
     * Кол-во посещений
     */
    @Column
    private int _cntLog = UserService._defaultCntLog;

    @Column
    private String _status = UserService._defaultStatus;
    /**
     * Конструктор
     * @param password пароль
     * @param login логин
     */
    public UserStore(String password, String login) {
        this._password = password;
        this._login = login;
    }

    /**
     * Получение идентификатора пользователя
     * @return идентификатор пользователя
     */
    public int getId() {
        return _id;
    }

    /**
     * Получение логина
     * @return логин
     */
    public String getLogin() {
        return _login;
    }

    /**
     * Получение пароля
     * @return пароль
     */
    public String getPassword() {
        return _password;
    }

    /**
     * Получение идентификатора изображения
     * @return идентификатор изображения
     */
    public int getIdImage(){
        return _idImage;
    }

    /**
     * Получение списка избранных товаров
     * @return список избранных товаров
     */
    public int[] getFavorites() {
        int[] localMass = new int[_favorites.length];
        for(int i =0; i < _favorites.length; i++){
            localMass[i] = _favorites[i];
        }
        return localMass;
    }

    /**
     * Получение роли
     * @return роль пользователя
     */
    public String getRole(){
        return _role;
    }

    /**
     * Получение счётчика посещений
     * @return счётчик посещений
     */
    public int getCntLog(){
        return _cntLog;
    }

    /**
     * Установка счётчика посещений
     * @param cntLog  счётчик посещений
     */
    public void setCntLog(int cntLog){
        _cntLog = cntLog;
    }

    /**
     * Установка идентификатора изображения
     * @param idImage идентификатор изображения
     */
    public void setIdImage(int idImage){
        _idImage = idImage;
    }

    /**
     * Установка идентификатора пользователя
     * @param id идентификатор пользователя
     */
    public void setId(int id) {
        _id = id;
    }

    /**
     * Установка роли
     * @param role роль
     */
    public void setRole(String role){
        _role = role;
    }

    /**
     * Установка логина
     * @param login логин
     */
    public void setLogin(String login) {
        _login = login;
    }

    /**
     * Установка пароля
     * @param password пароль
     */
    public void setPassword(String password) {
        _password = password;
    }

    /**
     * Установка списка избранных товаров
     * @param favorites список избранных товаров
     */
    public void setFavorites(int[] favorites){
        _favorites = favorites;
    }
}
