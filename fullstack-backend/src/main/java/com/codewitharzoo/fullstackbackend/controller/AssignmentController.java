package com.codewitharzoo.fullstackbackend.controller;
import com.codewitharzoo.fullstackbackend.model.Assignment;
import com.codewitharzoo.fullstackbackend.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@CrossOrigin("http://localhost:3000")
public class AssignmentController {

    private final AssignmentRepository assignmentRepository;

    @Autowired
    public AssignmentController(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    @PostMapping
    public ResponseEntity<String> submitAssignment(@RequestBody List<Assignment> assignments) {
        assignmentRepository.saveAll(assignments);
        return ResponseEntity.ok("Assignment submitted successfully!");
    }

    @GetMapping
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }
}
