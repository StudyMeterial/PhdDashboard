package com.codewitharzoo.fullstackbackend.controller;

//import com.codewitharzoo.fullstackbackend.model.LeaveApplication;
import com.codewitharzoo.fullstackbackend.model.LeaveApplication;
import com.codewitharzoo.fullstackbackend.model.LeaveApplicationUser;
//import com.codewitharzoo.fullstackbackend.model.Phdftstudent;
import com.codewitharzoo.fullstackbackend.model.User;
import com.codewitharzoo.fullstackbackend.repository.LeaveApplicationUserRepository;
import com.codewitharzoo.fullstackbackend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/api/leave-applications/user")
public class LeaveUserApplicationController {

    @Autowired
    private LeaveApplicationUserRepository leaveApplicationUserRepository;
    @Autowired
    private UserRepository userRepository;

    // Endpoint for submitting a leave application
//    @PostMapping("/submit")
//    public ResponseEntity<String> submitLeaveApplication(@RequestBody LeaveApplicationUser leaveApplicationUser) {
//        leaveApplicationUser.setStatus("PENDING");
//        leaveApplicationUserRepository.save(leaveApplicationUser);
//        return ResponseEntity.ok("Leave application submitted successfully. Pending admin approval.");
//    }
    @GetMapping
    public List<LeaveApplicationUser> getAllLeaveApplications() {
        return leaveApplicationUserRepository.findAll();
    }
    @PostMapping("/submit/{userId}")
    public ResponseEntity<String> submitLeaveApplication(
            @RequestBody LeaveApplicationUser leaveApplicationUser,
            @PathVariable Long userId) {
        try {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException("Phdftstudent not found with id: " + userId));
            leaveApplicationUser.setUser(user);
            leaveApplicationUser.setStatus("PENDING");
            leaveApplicationUserRepository.save(leaveApplicationUser);
            return ResponseEntity.ok("Leave application submitted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error submitting leave application: " + e.getMessage());
        }
    }
    // Endpoint for admin to approve a leave application
    @PutMapping("/approve/{id}")
    public ResponseEntity<String> approveLeaveApplication(@PathVariable Long id) {
        LeaveApplicationUser leaveApplicationUser = leaveApplicationUserRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Leave application not found with id: " + id));
        leaveApplicationUser.setStatus("APPROVED");
        leaveApplicationUserRepository.save(leaveApplicationUser);
        return ResponseEntity.ok("Leave application approved successfully.");
    }

    // Endpoint for admin to reject a leave application
    @PutMapping("/reject/{id}")
    public ResponseEntity<String> rejectLeaveApplication(@PathVariable Long id) {
        LeaveApplicationUser leaveApplicationUser = leaveApplicationUserRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Leave application not found with id: " + id));
        leaveApplicationUser.setStatus("REJECTED");
        leaveApplicationUserRepository.save(leaveApplicationUser);
        return ResponseEntity.ok("Leave application rejected.");
    }
}
