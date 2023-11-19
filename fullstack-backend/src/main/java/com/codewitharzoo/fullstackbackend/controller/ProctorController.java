package com.codewitharzoo.fullstackbackend.controller;// ProctorController.java
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;

import com.codewitharzoo.fullstackbackend.Service.ProctorService;
import com.codewitharzoo.fullstackbackend.model.Proctor;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proctors")
@CrossOrigin("http://localhost:3000")
public class ProctorController {

    @Autowired
    private ProctorService proctorService;

    @GetMapping
    public List<Proctor> getAllProctors() {
        return proctorService.getAllProctors();
    }

    @GetMapping("/{id}")
    public Proctor getProctorById(@PathVariable Long id) {
        return proctorService.getProctorById(id);
    }

    @PostMapping
    public Proctor createProctor(@RequestBody Proctor proctor) {
        return proctorService.saveProctor(proctor);
    }

    @PutMapping("/{id}")
    public Proctor updateProctor(@PathVariable Long id, @RequestBody Proctor proctor) {
        Proctor existingProctor = proctorService.getProctorById(id);

        if (existingProctor != null) {
            existingProctor.setName(proctor.getName());
            return proctorService.saveProctor(existingProctor);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProctor(@PathVariable Long id) {
        proctorService.deleteProctor(id);
    }
}
