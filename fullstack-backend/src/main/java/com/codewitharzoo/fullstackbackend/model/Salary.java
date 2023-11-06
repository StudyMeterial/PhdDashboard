package com.codewitharzoo.fullstackbackend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private int month;
    private int year;

    @ManyToOne
    @JoinColumn(name = "Phdftstudent_id", referencedColumnName = "id")
    private Phdftstudent employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Phdftstudent getEmployee() {
        return employee;
    }

    public void setEmployee(Phdftstudent employee) {
        this.employee = employee;
    }
    // Other fields, getters, setters, and constructors
}
