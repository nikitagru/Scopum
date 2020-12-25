package com.example.scopum.repository;

import com.example.scopum.Diet.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
