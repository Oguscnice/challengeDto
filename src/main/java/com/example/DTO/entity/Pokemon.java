package com.example.DTO.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer power;

    private String attribut;

    private Long user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getAttribut() {
        return attribut;
    }

    public void setAttribut(String attribut) {
        this.attribut = attribut;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
    public Pokemon() {}

    public Pokemon(String name, Integer power, String attribut, Long user) {
        this.name = name;
        this.power = power;
        this.attribut = attribut;
        this.user = user;
    }

    public Pokemon(Long id, String name, Integer power, String attribut, Long user) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.attribut = attribut;
        this.user = user;
    }
}
