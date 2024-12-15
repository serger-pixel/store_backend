package com.example.store.repositories;

import com.example.store.entities.Event;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<Event, Integer> {
}
