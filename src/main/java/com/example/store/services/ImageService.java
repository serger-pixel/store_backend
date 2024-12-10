package com.example.store.services;

import com.example.store.entities.Image;
import com.example.store.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс-сервис для изображений
 */
@Service
public class ImageService {
    /**
     * Репозиторий изображений
     */
    @Autowired
    private ImageRepository _imageRepository;

    /**
     * Получение изображения из базы данных
     * @param id идентификатор изображения
     * @return изображение
     */
    public Image getItem(int id){
        return _imageRepository.findById(id).get();
    }

    /**
     * Сохранение изображения в базе данных
     * @param image изображение
     * @return экземпляр сохранённой сущности
     */
    public Image saveImage(Image image){
        return _imageRepository.save(image);
    }
}
