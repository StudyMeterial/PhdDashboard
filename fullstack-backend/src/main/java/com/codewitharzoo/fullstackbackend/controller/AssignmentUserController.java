package com.codewitharzoo.fullstackbackend.controller;

import com.codewitharzoo.fullstackbackend.model.AssignmentUser;
import com.codewitharzoo.fullstackbackend.model.User;
import com.codewitharzoo.fullstackbackend.repository.AssignmentUserRepository;
import com.codewitharzoo.fullstackbackend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments/user")
@CrossOrigin("http://localhost:3000")  // Replace with your frontend's URL

public class AssignmentUserController {

    @Autowired
    private AssignmentUserRepository assignmentUserRepository;

    @Autowired
    private UserRepository userRepository;

    // Endpoint for submitting an assignment
    @PostMapping("/submit/{userId}")
    public ResponseEntity<String> submitAssignment(
            @RequestBody AssignmentUser assignmentUser,
            @PathVariable Long userId) {
        try {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
            assignmentUser.setUser(user);
            assignmentUser.setStatus("SUBMITTED");
            assignmentUserRepository.save(assignmentUser);
            return ResponseEntity.ok("Assignment submitted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error submitting assignment: " + e.getMessage());
        }
    }

    // Endpoint for fetching all assignments for a user
    @GetMapping("/all/{userId}")
    public ResponseEntity<String> getAllAssignmentsByUser(@PathVariable Long userId) {
        try {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
            List<AssignmentUser> assignments = assignmentUserRepository.findByUser(user);
            return ResponseEntity.ok(assignments.toString());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching assignments: " + e.getMessage());
        }
    }
}
