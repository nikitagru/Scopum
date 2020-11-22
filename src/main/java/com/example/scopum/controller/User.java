package com.example.scopum.controller;


import lombok.Data;
import javax.persistence.Id;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "public")
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
    @Id
    private Long chatId;
    @Column(name = "state")
    private Integer stateId;



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

    public double getWeight() {
        return 0.0;
    }

    public int getGrowth() {
        return 0;
    }

    public int getAge() {
        return 0;
    }

    public String getGender() {
        return "";
    }

    public double getEmployment() {
        return 0;
    }
}
