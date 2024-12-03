package com.example.store.services;

import com.example.store.entities.Product;
import com.example.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository _productRepository;

    public Product getProduct(int id){
        return _productRepository.findById(id).get();
    }

    public Iterable<Product> getAllProduct(){
        return _productRepository.findAll();
    }

    public Product saveProduct(Product product){
        return _productRepository.save(product);
    }
}
