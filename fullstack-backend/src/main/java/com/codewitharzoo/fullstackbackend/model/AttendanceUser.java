package com.codewitharzoo.fullstackbackend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "attendence_user")
public class AttendanceUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "admin_id")  // Name of the foreign key column in the attendance table
    private Admin admin;


    @ManyToOne
    @JoinColumn(name = "user_id")  // Name of the foreign key column in the attendance table
    private User user;

    private LocalDate date;
    private boolean present;

    // Getters and setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}
