package com.example.store.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.ArrayList;

public class ListEvent {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int _id;

    private ArrayList<Event> _list;

    public ListEvent() {
        this._list = new ArrayList<Event>();
    }

    public ArrayList<Event> getList() {
        return _list;
    }

    public int getId() {
        return _id;
    }

    public void addEvent(Event el){
        _list.add(el);
    }

    public void deleteEvent(Event el){
        _list.remove(el);
    }
}
