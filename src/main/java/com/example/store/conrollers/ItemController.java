package com.example.store.conrollers;

import com.example.store.entities.Item;
import com.example.store.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
public class ItemController {
    @Autowired
    private ItemService _service;

    @PostMapping(value = "items/post")
    public ResponseEntity<Item> postItem(@RequestBody Item item){
        return ResponseEntity.created(URI.create("/post")).body(_service.saveItem(item));
    }

    @GetMapping(value="items/get/{id}")
    public ResponseEntity <Item> getItem(@PathVariable(value = "id") String id){
        return ResponseEntity.ok().body(_service.getItem(Integer.parseInt(id)));
    }


}
