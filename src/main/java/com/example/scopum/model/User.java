package com.example.scopum.model;


import javax.persistence.Id;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "public")
public class User {

    @Id
    private Long chatId;
    @Column(name = "state")
    private Integer stateId;
    @Column(name = "age")
    private int age; // Возраст пользователя
    @Column(name = "weight")
    private double weight; // Вес пользователя
    @Column(name = "growth")
    private int growth; // Рост пользователя
    @Column(name = "gender")
    private String gender; // Пол пользователя
    @Column(name = "employment")
    private double employment; // Уровень занятости пользователя(1-5)
    @Column(name = "calories")
    private double calories;
    @Column(name = "proteins")
    private double proteins;
    @Column(name = "fat")
    private double fat;
    @Column(name = "carbohydrates")
    private double carbohydrates;
    @Column(name = "botfunction")
    private String botFunction;

    public String getBotFunction() {
        return botFunction;
    }

    public void setBotFunction(String botFunction) {
        this.botFunction = botFunction;
    }

    public double[] getCalPFC() {
        return new double[] {calories, proteins, fat, carbohydrates};
    }

    public void setCalPFC(double[] calPFC) {
        this.calories = calPFC[0];
        this.proteins = calPFC[1];
        this.fat = calPFC[2];
        this.carbohydrates = calPFC[3];
    }

    public Long getChatId() {
        return chatId;
    }


    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }


    public User() {

    }


    public User(Long chatId, Integer state) {
        this.chatId = chatId;
        this.stateId = state;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getGrowth() {
        return growth;
    }

    public void setGrowth(int growth) {
        this.growth = growth;
    }

    public String getGender() {
        return gender.toString();
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getEmployment() {
        return employment;
    }

    public void setEmployment(double employment) {
        this.employment = employment;
    }
}
