package com.example.store.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

/**
 * Класс-сущность новости
 */
@Entity
@Table
@NoArgsConstructor
public class Event {
    /**
     * Id новости
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int _id;

    /**
     * Заголовок новости
     */
    @Column
    private String _head;

    /**
     * Текст новости
     */
    @Column
    private String _text;

    /**
     * Время составления новости
     */
    @Column
    private String _time;

    /**
     * Автор новости
     */
    @Column
    private String _author;

    /**
     * Конструтор
     * @param text текст новости
     * @param time время составления новости
     * @param author автор новости
     */
    public Event(String text, String time, String author, String head) {
        this._text = text;
        this._time = time;
        this._author = author;
        this._head = head;
    }

    /**
     * Получение текста
     * @return текст
     */
    public String getText(){
        return _text;
    }

    /**
     * Получение времени
     * @return время
     */
    public String getTime(){
        return _time;
    }

    /**
     * Получение автора
     * @return автор
     */
    public String getAuthor(){
        return _author;
    }

    /**
     * Получение заголовка
     * @return заголовок
     */
    public String getHead(){return _head;}

    /**
     * Получение идентификатора
     * @return идентификатор
     */
    public int getId() {return _id;}

    /**
     * Установка текста
     * @param text текст
     */
    public void setText(String text){
        _text = text;
    }

    /**
     * Установка времени
     * @param time время
     */
    public void setTime(String time){
        _time = time;
    }

    /**
     * Установка автора
     * @param author автор
     */
    public void setAuthor(String author){
        _author = author;
    }

    /**
     * Установка заголовка
     * @param head заголовок
     */
    public void  setHead(String head){_head = head;}

    /**
     * Установка идентификатора
     * @param id идентификатор
     */
    public void setId(int id) {_id = id;}
}
