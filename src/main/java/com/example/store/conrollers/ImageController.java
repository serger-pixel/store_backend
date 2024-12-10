package com.example.store.conrollers;

import com.example.store.entities.Image;
import com.example.store.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;

/**
 * Класс-контроллер изображений
 */
@RestController
public class ImageController {
    /**
     * Сервис изображений
     */
    @Autowired
    private ImageService _service;

    /**
     * Получение изображения из базы данных
     * @param id идентификатор изображения
     * @return изображение в виде последовательности байтов
     */
    @GetMapping("/images/get/{id}")
    public ResponseEntity<Image> getImage(@PathVariable int id) {
        return ResponseEntity.ok().body( _service.getItem(id));
    }

    /**
     * Добавление изображения в базу данных
     * @param file файл изображения
     * @return результат добавления
     */
    @PostMapping("/images/post")
    public ResponseEntity<Image> postImage(@RequestParam MultipartFile file){
        try {
            Image image = new Image(file.getContentType(), file.getSize(), file.getBytes());
            return ResponseEntity.created(URI.create("/post")).body(_service.saveImage(image));
        }
        catch(IOException ex){
            return ResponseEntity.notFound().build();
        }
    }
}