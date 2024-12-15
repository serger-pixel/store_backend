package com.example.store.services;

import com.example.store.entities.Event;
import com.example.store.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
    @Autowired
    private NewsRepository _newsRepository;

    public Event getEvent(int id){
        return _newsRepository.findById(id).get();
    }

    public Iterable<Event> getNews(){
        return _newsRepository.findAll();
    }

    public void editEvent(Event localEvent, int id){
        Event event = _newsRepository.findById(id).get();
        event.setText(localEvent.getText());
        _newsRepository.save(event);
    }

    public void delete(int id){
        _newsRepository.deleteById(id);
    }
}
