package com.codewitharzoo.fullstackbackend.model;
// Proctor.java
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import jakarta.persistence.*;

@Entity
public class Proctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // getters and setters

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

    // Constructors
    public Proctor() {
    }

    public Proctor(String name) {
        this.name = name;
    }
}
