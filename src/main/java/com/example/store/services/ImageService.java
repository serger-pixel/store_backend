package com.example.store.services;

import com.example.store.entities.Image;
import com.example.store.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    private ImageRepository _imageRepository;

    public Optional<Image> getItem(int id){
        return _imageRepository.findById(id);
    }

    public Image saveImage(Image image){
        return _imageRepository.save(image);
    }
}
