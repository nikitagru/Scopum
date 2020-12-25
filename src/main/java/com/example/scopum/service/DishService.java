package com.example.scopum.service;

import com.example.scopum.Diet.Dish;
import com.example.scopum.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Сервис для работы с репозиторием
 */
@Service
public class DishService {

    @Autowired
    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }


    /**
     * Получение всех блюд из БД
     * @return Итерируемая коллекция блюд
     */
    public Iterable<Dish> findAll() {
        return dishRepository.findAll();
    }
}
