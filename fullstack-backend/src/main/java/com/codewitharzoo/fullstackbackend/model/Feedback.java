package com.codewitharzoo.fullstackbackend.model;

import jakarta.persistence.*;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String feedbackText;
    private String feedbackType;
    private int rating;
    private String reviewerName;
    private String reviewerEmail;
    private boolean isAnonymous;
    @ManyToOne
    @JoinColumn(name = "student_id_PHD")
    private Phdftstudent student;
    // Constructors, getters, and setters


    public Phdftstudent getStudent() {
        return student;
    }

    public void setStudent(Phdftstudent student) {
        this.student = student;
    }

    public Feedback() {
        // Default constructor
    }


    public Feedback(String feedbackText, String feedbackType, int rating, String reviewerName, String reviewerEmail, boolean isAnonymous) {
        this.feedbackText = feedbackText;
        this.feedbackType = feedbackType;
        this.rating = rating;
        this.reviewerName = reviewerName;
        this.reviewerEmail = reviewerEmail;
        this.isAnonymous = isAnonymous;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public String getFeedbackType() {
        return feedbackType;
    }

    public void setFeedbackType(String feedbackType) {
        this.feedbackType = feedbackType;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getReviewerEmail() {
        return reviewerEmail;
    }

    public void setReviewerEmail(String reviewerEmail) {
        this.reviewerEmail = reviewerEmail;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }
}
