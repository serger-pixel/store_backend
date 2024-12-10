package com.example.store.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

/**
 * Класс-сущность товара
 */
@Entity
@Table
@NoArgsConstructor
public class Product {
    /**
     * Идентификатор товара
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private int _id;

    /**
     * Цена товара
     */
    @Column
    private int _price;

    /**
     * Название товара
     */
    @Column
    private String _name;

    /**
     * Валюта
     */
    @Column
    private String _valute;

    /**
     * Описание товара
     */
    @Column(length = 1000)
    private String _description;

    /**
     * Идентификатор изображения товара
     */
    @Column
    private int _idImage;

    /**
     * Конструктор
     * @param price Цена товара
     * @param idImage Идентификатор изображения товара
     * @param name Название товара
     * @param valute Валюта
     * @param description Описание товара
     */
    public Product(int price, int idImage, String name, String valute, String description) {
        this._price = price;
        this._idImage = idImage;
        this._name = name;
        this._valute = valute;
        this._description = description;
    }

    /**
     * Получение цены
     * @return цена товара
     */
    public int getPrice() {
        return _price;
    }

    /**
     * Получение идентификатора
     * @return идентификатор товара
     */
    public int getId() {
        return _id;
    }

    /**
     * Получение названия
     * @return название товара
     */
    public String getName() {
        return _name;
    }

    /**
     * Установка идентификатора товара
     * @param id идентификатор товара
     */
    public void setId(int id) {
        this._id = id;
    }

    /**
     * Установка названия товара
     * @param name название товара
     */
    public void setName(String name) {
        this._name = name;
    }

    /**
     * Установка цены товара
     * @param price цена товара
     */
    public void setPrice(int price) {
        this._price = price;
    }

    /**
     * Установка валюты
     * @param valute валюта
     */
    public void setValute(String valute){
        this._valute = valute;
    }

    /**
     * Получение валюты
     * @return валюта
     */
    public String getValute(){
        return this._valute;
    }

    /**
     * Установка описания
     * @param description описание товара
     */
    public void setDescription(String description){
        this._description = description;
    }

    /**
     * Получение описания
     * @return описание товара
     */
    public String getDescription(){
        return this._description;
    }

    /**
     * Установка идентификатора изображения
     * @param idImage идентификатор изображения товара
     */
    public void setIdImage(int idImage){
        this._idImage = idImage;
    }

    /**
     * Получение идентификатора изображения
     * @return идентификатор изображения товара
     */
    public int getIdImage(){
        return this._idImage;
    }
}
