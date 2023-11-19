package com.codewitharzoo.fullstackbackend.controller;

import com.codewitharzoo.fullstackbackend.model.Admin;
import com.codewitharzoo.fullstackbackend.model.LoginRequest;
import com.codewitharzoo.fullstackbackend.model.Phdftstudent;
import com.codewitharzoo.fullstackbackend.model.User;
import com.codewitharzoo.fullstackbackend.repository.AdminRepository;
import com.codewitharzoo.fullstackbackend.repository.Phdstudent_FulltimeRepository;
import com.codewitharzoo.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private Phdstudent_FulltimeRepository phdstudentFulltimeRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        Admin admin = adminRepository.findByUsername(loginRequest.getUsername());
        Phdftstudent phdftstudent = phdstudentFulltimeRepository.findByUsername(loginRequest.getUsername());

        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(user);
        } else if (admin != null && admin.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(admin);
        } else if (phdftstudent != null && phdftstudent.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(phdftstudent);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password.");
        }
    }
}
