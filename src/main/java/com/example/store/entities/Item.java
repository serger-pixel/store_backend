package com.example.store.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int _id;

    private int _price;

    private String _name;

    private String _valute;

    private String _desctiption;

    public Item(int price, String name, String valute) {
        this._price = price;
        this._name = name;
        this._valute = valute;
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

    public String getValute(String valute){
        return this._valute;
    }

    public void setDesctiption(String desctiption){
        this._desctiption = desctiption;
    }

    public String getDesctiption(String desctiption){
        return this._desctiption;
    }
}
