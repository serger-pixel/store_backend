package com.example.store.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int _id;

    private String _text;

    public Event(String text) {
        this._text = text;
    }

    public int getId() {
        return _id;
    }

    public String getText() {
        return _text;
    }

    public void setId(int id) {
        this._id = id;
    }

    public void setText(String text) {
        this._text = text;
    }
}
