package com.codewitharzoo.fullstackbackend.controller;

import com.codewitharzoo.fullstackbackend.model.Admin;
import com.codewitharzoo.fullstackbackend.model.AttendanceUser;
import com.codewitharzoo.fullstackbackend.model.User;
import com.codewitharzoo.fullstackbackend.repository.AdminRepository;
import com.codewitharzoo.fullstackbackend.repository.AttendanceUserRepository;
import com.codewitharzoo.fullstackbackend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/admin/attendance")
@CrossOrigin("http://localhost:3000")
public class AdminAttendanceController {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AttendanceUserRepository attendanceUserRepository;

    // Endpoint for submitting attendance
    @PostMapping("/submit/{adminId}/{userId}")
    public ResponseEntity<String> submitAttendance(
            @PathVariable Long adminId,
            @PathVariable Long userId,
            @RequestBody AttendanceUser attendanceUser) {
        try {
            Admin admin = adminRepository.findById(adminId)
                    .orElseThrow(() -> new EntityNotFoundException("Admin not found with id: " + adminId));

            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

            attendanceUser.setAdmin(admin);
            attendanceUser.setUser(user);
            attendanceUser.setDate(LocalDate.now());

            // Save the attendance record
            attendanceUserRepository.save(attendanceUser);

            return ResponseEntity.ok("Attendance submitted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error submitting attendance: " + e.getMessage());
        }
    }

    // Endpoint for viewing attendance records for a user
    @GetMapping("/view/{userId}")
    public ResponseEntity<String> viewAttendance(@PathVariable Long userId) {
        try {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
            List<AttendanceUser> attendanceRecords = attendanceUserRepository.findByUser(user);
            return ResponseEntity.ok(String.valueOf(attendanceRecords));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error retrieving attendance records: " + e.getMessage());
        }
    }
}
