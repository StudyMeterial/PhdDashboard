package com.codewitharzoo.fullstackbackend.controller;
import com.codewitharzoo.fullstackbackend.model.Admin;
import com.codewitharzoo.fullstackbackend.model.Phdftstudent;
import com.codewitharzoo.fullstackbackend.model.User;
import com.codewitharzoo.fullstackbackend.repository.AdminRepository;
import com.codewitharzoo.fullstackbackend.repository.Phdstudent_FulltimeRepository;
import com.codewitharzoo.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("http://localhost:3000")
public class AdminController {


    private final AdminRepository adminRepository;
    private final UserRepository userRepository;
    private final Phdstudent_FulltimeRepository phdstudent_fulltimeRepository;


    @Autowired
    public AdminController(AdminRepository adminRepository, UserRepository userRepository, Phdstudent_FulltimeRepository phdstudentFulltimeRepository) {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
        phdstudent_fulltimeRepository = phdstudentFulltimeRepository;
    }

//    @PostMapping("/login")
//    public String login(@RequestBody Admin loginRequest) {
//        Admin admin = adminRepository.findByUsername(loginRequest.getUsername());
//        User user = userRepository.findByUsername(loginRequest.getUsername());
//        Phdftstudent phdftstudent=phdstudent_fulltimeRepository.findByUsername(loginRequest.getUsername());
//        if (admin != null && admin.getPassword().equals(loginRequest.getPassword())) {
//            return "Login successful!";
//
//        } else if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
//            return "HalfTime login successfully.";
//        }
//        else if (phdftstudent != null && phdftstudent.getPassword().equals(loginRequest.getPassword())) {
//            return "Fulltime login successfully.";
//        }
//        else {
//            return "Invalid username or password.";
//        }
//    }
//==================================================================================

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Admin adminLoginRequest,
                                        @RequestBody User userLoginRequest,
                                        @RequestBody Phdftstudent phdftstudentLoginRequest) {

        // Validate admin credentials
        Optional<Admin> existingAdmin = adminRepository.findByUsernameAndPassword(adminLoginRequest.getUsername(), adminLoginRequest.getPassword());
        if (existingAdmin.isPresent()) {
            return ResponseEntity.ok("Admin login successful");
        }

        // Validate user credentials
        Optional<User> existingUser = userRepository.findByUsernameAndPassword(userLoginRequest.getUsername(), userLoginRequest.getPassword());
        if (existingUser.isPresent()) {
            return ResponseEntity.ok("User login successful");
        }

        // Validate Phdftstudent credentials
        Optional<Phdftstudent> existingPhdftstudent = phdstudent_fulltimeRepository.findByUsernameAndPassword(phdftstudentLoginRequest.getUsername(), phdftstudentLoginRequest.getPassword());
        if (existingPhdftstudent.isPresent()) {
            return ResponseEntity.ok("Phdftstudent login successful");
        }

        // If no valid credentials found, return unauthorized
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

//    =====================================================================


}

