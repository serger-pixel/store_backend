package com.example.store.repositories;

import com.example.store.entities.Image;
import org.springframework.data.repository.CrudRepository;

/**
 * Интерфейс репозитория изображений
 */
public interface ImageRepository extends CrudRepository<Image, Integer> {
}
