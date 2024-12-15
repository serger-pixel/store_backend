package com.example.store.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
public class Event {
    /**
     * Id новости
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int _id;

    /**
     * Текст новости
     */
    private String _text;

    /**
     * Время составления новости
     */
    private String _time;

    /**
     * Автор новости
     */
    private String _author;

    /**
     * Конструтор
     * @param text текст новости
     * @param time время составления новости
     * @param author автор новости
     */
    public Event(String text, String time, String author) {
        this._text = text;
        this._time = time;
        this._author = author;
    }

    public String getText(){
        return _text;
    }

    public String getTime(){
        return _time;
    }

    public String getAuthor(){
        return _author;
    }

    public void setText(String text){
        _text = text;
    }

    public void setTime(String time){
        _time = time;
    }

    public void setAuthor(String author){
        _author = author;
    }
}
