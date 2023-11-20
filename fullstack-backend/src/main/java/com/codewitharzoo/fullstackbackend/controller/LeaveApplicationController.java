package com.codewitharzoo.fullstackbackend.controller;

import com.codewitharzoo.fullstackbackend.model.LeaveApplication;
import com.codewitharzoo.fullstackbackend.model.Phdftstudent;
import com.codewitharzoo.fullstackbackend.repository.LeaveApplicationRepository;
//import com.codewitharzoo.fullstackbackend.repository.PhdftstudentRepository;
import com.codewitharzoo.fullstackbackend.repository.Phdstudent_FulltimeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/leave-applications")
@CrossOrigin("http://localhost:3000")
public class LeaveApplicationController {

    @Autowired
    private LeaveApplicationRepository leaveApplicationRepository;

    @Autowired
    private Phdstudent_FulltimeRepository phdftstudentRepository;

    @GetMapping
    public List<LeaveApplication> getAllLeaveApplications() {
        return leaveApplicationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveApplication> getLeaveApplicationById(@PathVariable Long id) {
        return ResponseEntity.of(leaveApplicationRepository.findById(id));
    }

    @PostMapping("/submit/{phdStudentId}")
    public ResponseEntity<String> submitLeaveApplication(
            @RequestBody LeaveApplication leaveApplication,
            @PathVariable Long phdStudentId) {
        try {
            Phdftstudent phdStudent = phdftstudentRepository.findById(phdStudentId)
                    .orElseThrow(() -> new EntityNotFoundException("Phdftstudent not found with id: " + phdStudentId));
            leaveApplication.setPhdStudent(phdStudent);
            leaveApplication.setStatus("PENDING");
            leaveApplicationRepository.save(leaveApplication);
            return ResponseEntity.ok("Leave application submitted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error submitting leave application: " + e.getMessage());
        }
    }

    @PutMapping("/approve/{id}")
    public ResponseEntity<String> approveLeaveApplication(@PathVariable Long id) {
        try {
            LeaveApplication leaveApplication = leaveApplicationRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("LeaveApplication not found with id: " + id));
            leaveApplication.setStatus("APPROVED");
            leaveApplicationRepository.save(leaveApplication);
            return ResponseEntity.ok("Leave application approved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error approving leave application: " + e.getMessage());
        }
    }

    @PutMapping("/reject/{id}")
    public ResponseEntity<String> rejectLeaveApplication(@PathVariable Long id) {
        try {
            LeaveApplication leaveApplication = leaveApplicationRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("LeaveApplication not found with id: " + id));
            leaveApplication.setStatus("REJECTED");
            leaveApplicationRepository.save(leaveApplication);
            return ResponseEntity.ok("Leave application rejected successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error rejecting leave application: " + e.getMessage());
        }
    }
}
