package com.example.store.services;

import com.example.store.entities.Event;
import com.example.store.entities.Product;
import com.example.store.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Класс-сервис для новостей
 */
@Service
public class NewsService{

    /**
     * Репозиторий новостей
     */
    @Autowired
    public NewsRepository _newsRepository;

    /**
     * Получение новости
     * @param id идентификатор новости
     * @return новость
     */
    public Event getEvent(int id){
        return _newsRepository.findById(id).get();
    }

    /**
     * Получение всех новостей
     * @return список новостей
     */
    public Iterable<Event> getNews(){
        return _newsRepository.findAll();
    }

    /**
     * Редактироване новости
     * @param localEvent новая новость
     * @param id идентификатор старой новости
     */
    public void editEvent(Event localEvent, int id){
        Event event = _newsRepository.findById(id).get();
        event.setText(localEvent.getText());
        _newsRepository.save(event);
    }

    /**
     * Удаление новости
     * @param id идентификатор новости
     */
    public void delete(int id){
        _newsRepository.deleteById(id);
    }

    /**
     * Сохранение новости в базе данных
     * @param event новость
     * @return экземпляр сохранённой сущности
     */
    public Event saveEvent(Event event){
        return _newsRepository.save(event);
    }

    /**
     * Получение новостей данного автора
     * @param author автор
     * @return список новостей
     */
    public Iterable<Event> getMyNews(String author){
        Iterable<Event> allNews = _newsRepository.findAll();
        ArrayList<Event> myNews = new ArrayList<>();

        for(Event event : allNews){
            myNews.add(event);
        }
        return myNews;
    }
}
