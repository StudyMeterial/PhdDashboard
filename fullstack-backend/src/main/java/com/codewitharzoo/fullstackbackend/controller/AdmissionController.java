package com.codewitharzoo.fullstackbackend.controller;
import com.codewitharzoo.fullstackbackend.model.Admission;
import com.codewitharzoo.fullstackbackend.repository.admisssionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("http://localhost:3000")
public class AdmissionController {


    private final admisssionRepository admisssionrepository;

    @Autowired
    public AdmissionController(admisssionRepository admisssionrepository) {
        this.admisssionrepository = admisssionrepository;
    }

    @PostMapping("/admission")
    public ResponseEntity<?> submitAdmission(@RequestBody Admission admission) {
        // Validate the admission form data
        if (admission.getFullname() == null || admission.getEmail() == null || admission.getUsername() == null ||
                admission.getPassword() == null || admission.getQualification() == null || admission.getVillage() == null ||
                admission.getDist() == null || admission.getState() == null) {
            return ResponseEntity.badRequest().body("All fields are required.");
        }

        // Additional validation and processing logic can be added here

        // Save the admission object to the repository
        Admission savedAdmission = admisssionrepository.save(admission);

        // Assuming validation and processing are successful, return the saved object
        return ResponseEntity.ok(savedAdmission);
    }
}
