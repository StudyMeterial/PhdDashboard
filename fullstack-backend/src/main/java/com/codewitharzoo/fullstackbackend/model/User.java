package com.codewitharzoo.fullstackbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private String PhdStudentHalf;
    private String email;
    private String username;
    private String password;
    private String qualification;
    private String village;
    private String dist;
    private String state;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<LeaveApplicationUser> leaveApplicationUsers;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<AssignmentUser> assignmentUsers;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<AttendanceUser> attendanceUsers;

    public Set<AttendanceUser> getAttendanceUsers() {
        return attendanceUsers;
    }

    public void setAttendanceUsers(Set<AttendanceUser> attendanceUsers) {
        this.attendanceUsers = attendanceUsers;
    }
// Getters and setters...

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

    public String getPhdStudentHalf() {
        return PhdStudentHalf;
    }

    public void setPhdStudentHalf(String phdStudentHalf) {
        PhdStudentHalf = phdStudentHalf;
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

    public Set<LeaveApplicationUser> getleaveApplicationUsers() {
        return leaveApplicationUsers;
    }

    public void setleaveApplicationUsers(Set<LeaveApplicationUser> leaveApplicationUsers) {
        this.leaveApplicationUsers = leaveApplicationUsers;
    }

    public Set<LeaveApplicationUser> getLeaveApplicationUsers() {
        return leaveApplicationUsers;
    }

    public void setLeaveApplicationUsers(Set<LeaveApplicationUser> leaveApplicationUsers) {
        this.leaveApplicationUsers = leaveApplicationUsers;
    }

    public Set<AssignmentUser> getAssignmentUsers() {
        return assignmentUsers;
    }

    public void setAssignmentUsers(Set<AssignmentUser> assignmentUsers) {
        this.assignmentUsers = assignmentUsers;
    }
}
