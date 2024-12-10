package com.example.store.repositories;

import com.example.store.entities.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Интерфейс репозитория товаров
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
