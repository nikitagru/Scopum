package com.example.scopum.service;

import com.example.scopum.Diet.Product;
import com.example.scopum.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    /**
     * Получение всех блюд из БД
     * @return Итерируемая коллекция блюд
     */
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }
}
