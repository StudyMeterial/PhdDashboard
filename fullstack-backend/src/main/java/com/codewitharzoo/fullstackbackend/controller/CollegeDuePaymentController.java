package com.codewitharzoo.fullstackbackend.controller;

import com.codewitharzoo.fullstackbackend.model.CollegeDuePayment;
import com.codewitharzoo.fullstackbackend.model.Phdftstudent;
import com.codewitharzoo.fullstackbackend.repository.CollegeDuePaymentRepository;
import com.codewitharzoo.fullstackbackend.repository.Phdstudent_FulltimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/college-due-payment")
public class CollegeDuePaymentController {

    @Autowired
    private CollegeDuePaymentRepository collegeDuePaymentRepository;

    @Autowired
    private Phdstudent_FulltimeRepository phdftstudentRepository;

    @PostMapping("/add/{studentId}")
    public String addCollegeDuePayment(@PathVariable Long studentId, @RequestBody CollegeDuePayment collegeDuePayment) {
        // Fetch the student from the database
        Optional<Phdftstudent> optionalPhdftstudent = phdftstudentRepository.findById(studentId);

        // Check if the student exists
        if (optionalPhdftstudent.isPresent()) {
            Phdftstudent phdftstudent = optionalPhdftstudent.get();

            // Associate the college due payment with the student
            collegeDuePayment.setPhdftstudent(phdftstudent);

            // Save the college due payment
            collegeDuePaymentRepository.save(collegeDuePayment);

            return "College due payment added successfully";
        } else {
            return "Student not found";
        }
    }

    @GetMapping("/all")
    public List<CollegeDuePayment> getAllCollegeDuePayments() {
        return collegeDuePaymentRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<CollegeDuePayment> getCollegeDuePaymentById(@PathVariable Long id) {
        Optional<CollegeDuePayment> collegeDuePayment = collegeDuePaymentRepository.findById(id);

        return collegeDuePayment.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
