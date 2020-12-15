package com.example.scopum.Diet;

import javax.persistence.*;

@Entity
@Table(name = "dish")
public class Dish {

    @Id
    private long id;
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
    @Column(name = "recipe")
    private String recipe;
    @Column(name = "ingredients")
    private String ingredients;
    @Column(name = "picturename")
    private String pictureName;
    @Column(name = "time")
    private String time;

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

    public String getRecipe() {
        return recipe;
    }

    public String getPictureName() {
        return pictureName;
    }

    public String getTime() {
        return time;
    }

    public String getIngredients() {
        return ingredients;
    }


    public double[] getCalPFC() {
        return new double[] {calories, proteins, fat, carbohydrates};
    }

    public Dish() {

    }
}
