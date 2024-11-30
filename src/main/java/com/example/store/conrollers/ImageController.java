package com.example.store.conrollers;

import com.example.store.entities.Image;
import com.example.store.services.ImageService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.net.URI;
import java.util.Optional;

@RestController
public class ImageController {
    private ImageService _service;

    @GetMapping("/images/get/{id}")
    public ResponseEntity<InputStreamResource> getImage(@PathVariable int id) {
        Optional<Image> image = _service.getItem(id);
        return ResponseEntity.ok()
                .body(new InputStreamResource(new ByteArrayInputStream(image.get().getBytes())));
    }

    @PostMapping("/images/post")
    public ResponseEntity<Image> postImage(@RequestBody Image image){
        return ResponseEntity.created(URI.create("/post")).body(_service.saveImage(image));
    }
}