package com.example.scopum.Diet;

import javax.persistence.*;

/**
 * Сущность продукта
 */
@Entity
@Table(name = "product")
public class Product {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "calories")
    private double calories;
    @Column(name = "proteins")
    private double proteins;
    @Column(name = "fat")
    private double fat;
    @Column(name = "carbohydrates")
    private double carbohydrates;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCalories() {
        return calories;
    }

    public double getProteins() {
        return proteins;
    }

    public double getFat() {
        return fat;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public Product ()
    {

    }

}
