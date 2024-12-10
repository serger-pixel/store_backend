package com.example.store.services;

import com.example.store.entities.Product;
import com.example.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс-сервис для товаров
 */
@Service
public class ProductService {
    /**
     * Репоситорий товаров
     */
    @Autowired
    private ProductRepository _productRepository;

    /**
     * Получение товара из базы данных
     * @param id идентификатор товара
     * @return товар
     */
    public Product getProduct(int id){
        return _productRepository.findById(id).get();
    }

    /**
     * Получение всех товаров из базы данных
     * @return список товаров
     */
    public Iterable<Product> getAllProduct(){
        return _productRepository.findAll();
    }

    /**
     * Сохранение товара в базе данных
     * @param product товар
     * @return экземпляр сохранённой сущности
     */
    public Product saveProduct(Product product){
        return _productRepository.save(product);
    }
}
