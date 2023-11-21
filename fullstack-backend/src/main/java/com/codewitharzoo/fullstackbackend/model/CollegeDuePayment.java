package com.codewitharzoo.fullstackbackend.model;

import jakarta.persistence.*;

@Entity
public class CollegeDuePayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private Integer year;
    private Boolean isPaid;

    @ManyToOne
    @JoinColumn(name = "phdftstudent_id")
    private Phdftstudent phdftstudent;

    public Phdftstudent getPhdftstudent() {
        return phdftstudent;
    }

    public void setPhdftstudent(Phdftstudent phdftstudent) {
        this.phdftstudent = phdftstudent;
    }

    // Add getters and setters for other fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }
}
