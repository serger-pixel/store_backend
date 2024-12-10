package com.example.store.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private int _id;

    @Column
    private int _price;

    @Column
    private String _name;

    @Column
    private String _valute;

    @Column(length = 1000)
    private String _description;

    @Column
    private int _idImage;

    public Product(int price, int idImage, String name, String valute, String description) {
        this._price = price;
        this._idImage = idImage;
        this._name = name;
        this._valute = valute;
        this._description = description;
    }

    public int getPrice() {
        return _price;
    }

    public int getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public void setId(int id) {
        this._id = id;
    }

    public void setName(String name) {
        this._name = name;
    }

    public void setPrice(int price) {
        this._price = price;
    }

    public void setValute(String valute){
        this._valute = valute;
    }

    public String getValute(){
        return this._valute;
    }

    public void setDescription(String description){
        this._description = description;
    }

    public String getDescription(){
        return this._description;
    }

    public void setIdImage(int idImage){
        this._idImage = idImage;
    }

    public int getIdImage(){
        return this._idImage;
    }
}
