package com.example.scopum.repository;

import com.example.scopum.Diet.Dish;
import org.springframework.data.repository.CrudRepository;

/**
 * Репозиторий всех блюд
 */
public interface DishRepository extends CrudRepository<Dish, Long> {
    Dish findByName(String name);
}
