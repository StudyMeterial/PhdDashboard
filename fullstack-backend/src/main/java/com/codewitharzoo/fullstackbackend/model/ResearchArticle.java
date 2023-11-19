package com.codewitharzoo.fullstackbackend.model;
import jakarta.persistence.*;


@Entity
public class ResearchArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;

    private String content;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
