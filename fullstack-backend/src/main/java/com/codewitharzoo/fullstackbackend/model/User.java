package com.codewitharzoo.fullstackbackend.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private String PhdStudentHalf;

    public String getPhdStudentHalf() {
        return PhdStudentHalf;
    }

    public void setPhdStudentHalf(String phdStudentHalf) {
        PhdStudentHalf = phdStudentHalf;
    }

    private String email;
    private String username;
    private String password;
    private String qualification;
    private String village;
    private String dist;
    private String state;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "USER_ROLE",
//            joinColumns = {
//                    @JoinColumn(name = "USER_ID")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "ROLE_ID")
//            }
//    )
//    private Set<Role> role;

//    public Set<Role> getRole() {
//        return role;
//    }
//
//    public void setRole(Set<Role> role) {
//        this.role = role;
//    }

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
