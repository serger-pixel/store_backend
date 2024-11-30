package com.example.store.services;

import com.example.store.entities.Item;
import com.example.store.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository _itemRepository;

    public Item getItem(int id){
        return _itemRepository.findById(id).get();
    }

    public  Item saveItem(Item item){
        return _itemRepository.save(item);
    }
}
