package com.example.store.conrollers;

import com.example.store.entities.Product;
import com.example.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class ProductController {
    @Autowired
    private ProductService _service;

//    @PostMapping(value = "items/post")
//    public ResponseEntity<Product> postItem(@RequestBody Product product){
//        return ResponseEntity.created(URI.create("/post")).body(_service.saveProduct(product));
//    }

    @GetMapping(value="items/get/{id}")
    public ResponseEntity <Product> getItem(@PathVariable(value = "id") String id){
        return ResponseEntity.ok().body(_service.getProduct(Integer.parseInt(id)));
    }

    @GetMapping(value="items/get/all")
    public ResponseEntity <Iterable<Product>> getAllItem(){
        return ResponseEntity.ok().body(_service.getAllProduct());
    }
}
