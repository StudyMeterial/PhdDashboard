package com.codewitharzoo.fullstackbackend.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Phdftstudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private String PhdStudent;
    private String email;
    private String username;
    private String password;
    private String qualification;
    private String village;
    private String dist;
    private String state;

    @ManyToOne
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    @OneToMany(mappedBy = "phdftstudent", cascade = CascadeType.ALL)
    @JsonManagedReference // or @JsonIgnore if using Jackson 2.9 or higher
    private List<ReportFullTime> reports;

    public List<ReportFullTime> getReports() {
        return reports;
    }

    public void setReports(List<ReportFullTime> reports) {
        this.reports = reports;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhdStudent() {
        return PhdStudent;
    }

    public void setPhdStudent(String phdStudent) {
        PhdStudent = phdStudent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}
