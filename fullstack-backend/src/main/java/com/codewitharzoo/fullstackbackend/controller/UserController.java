package com.codewitharzoo.fullstackbackend.controller;

import com.codewitharzoo.fullstackbackend.exception.UserNotFoundException;
import com.codewitharzoo.fullstackbackend.model.Admin;
import com.codewitharzoo.fullstackbackend.model.Admission;
import com.codewitharzoo.fullstackbackend.model.User;
import com.codewitharzoo.fullstackbackend.repository.UserRepository;
//import org.springframework.stereotype.;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    public final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
    }


    @PostMapping("/user")
    public ResponseEntity<?> submitAdmission(@RequestBody User user) {
        // Validate the admission form data
        if (user.getFullname() == null || user.getEmail() == null ||  user.getPhdStudentHalf() == null ||user.getUsername() == null ||
                user.getPassword() == null || user.getQualification() == null || user.getVillage() == null ||
                user.getDist() == null || user.getState() == null) {
            return ResponseEntity.badRequest().body("All fields are required.");
        }



        // Save the admission object to the repository
        User savedUser = userRepository.save(user);

        // Assuming validation and processing are successful, return the saved object
        return ResponseEntity.ok(savedUser);
    }

    //find all users
    @GetMapping("/users")
    Iterable<User> getAllUser(){
        return userRepository.findAll();
    }
    @GetMapping("/count")
    public Long countUsers() {
        return userRepository.count();
    }

    //find by

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }
//    @GetMapping("/user/{username}")
//    User getUserByUsername(@PathVariable String username){
//        return userRepository.findByUsername(username).orElseThrow(()->new UserNotFoundException(username));
//    }


    //update user
    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long id){
        return userRepository.findById(id).map(user -> {
                user.setUsername(newUser.getUsername());
                user.setPassword(newUser.getPassword());
//                user.setEmail(newUser.getEmail());
                return userRepository.save(user);
        }).orElseThrow(() ->new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if (!userRepository.existsById(id)) {

            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id "+id+" has been deleted success.";
    }



}
