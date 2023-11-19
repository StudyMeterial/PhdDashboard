package com.codewitharzoo.fullstackbackend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "LeaveApplication")
public class LeaveApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String startDate;
    private String endDate;
    private String reason;

    @ManyToOne
    @JoinColumn(name = "phd_student_id")
    private Phdftstudent phdStudent;

    private String status = "PENDING"; // Default status is PENDING

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Phdftstudent getPhdStudent() {
        return phdStudent;
    }

    public void setPhdStudent(Phdftstudent phdStudent) {
        this.phdStudent = phdStudent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
