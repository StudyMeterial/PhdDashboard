package com.codewitharzoo.fullstackbackend.controller;

import com.codewitharzoo.fullstackbackend.exception.UserNotFoundException;
import com.codewitharzoo.fullstackbackend.model.Phdftstudent;
import com.codewitharzoo.fullstackbackend.repository.Phdstudent_FulltimeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class phdstudent_fulltimeController {


    private  final Phdstudent_FulltimeRepository phdstudentFulltimeRepository;

    public phdstudent_fulltimeController(Phdstudent_FulltimeRepository phdstudentFulltimeRepository) {
        this.phdstudentFulltimeRepository = phdstudentFulltimeRepository;
    }
//    private final SalaryRepository salaryRepository;
//
//    public phdstudent_fulltimeController(Phdstudent_FulltimeRepository phdstudentFulltimeRepository, SalaryRepository salaryRepository) {
//        this.phdstudentFulltimeRepository = phdstudentFulltimeRepository;
//        this.salaryRepository = salaryRepository;
//    }


    @PostMapping("/phdstudentft")
    public ResponseEntity<?> submitAdmission(@RequestBody Phdftstudent phdftstudent) {
        // Validate the admission form data
        if (phdftstudent.getFullname() == null || phdftstudent.getEmail() == null ||  phdftstudent.getUsername() == null ||
                phdftstudent.getPassword() == null || phdftstudent.getQualification() == null || phdftstudent.getVillage() == null ||
                phdftstudent.getDist() == null || phdftstudent.getState() == null) {
            return ResponseEntity.badRequest().body("All fields are required.");
        }

        // Additional validation and processing logic can be added here

        // Save the admission object to the repository
        Phdftstudent savedPhdftstudent = phdstudentFulltimeRepository.save(phdftstudent);

        // Assuming validation and processing are successful, return the saved object
        return ResponseEntity.ok(savedPhdftstudent);
    }
//
    //view student of phd fulltime
    @GetMapping("/phdstudentfts")
    Iterable<Phdftstudent> getAllphdstudent_fulltime()
    {
        return phdstudentFulltimeRepository.findAll();
    }

    //find by id

    @GetMapping("/phdstudentft/{id}")
    Phdftstudent getphdstudentftById(@PathVariable Long id){
        return phdstudentFulltimeRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/phdstudentft/{id}")
    Phdftstudent updatephdstudent_fulltime(@RequestBody Phdftstudent newPhdstudent_fulltime, @PathVariable Long id){
        return phdstudentFulltimeRepository.findById(id).map(phdstudent_fulltime -> {
            phdstudent_fulltime.setUsername(newPhdstudent_fulltime.getUsername());
            phdstudent_fulltime.setPassword(newPhdstudent_fulltime.getPassword());

            return phdstudentFulltimeRepository.save(phdstudent_fulltime);
        }).orElseThrow(() ->new UserNotFoundException(id));
    }

    @DeleteMapping("/phdstudentft/{id}")
    String deleteUser(@PathVariable Long id){
        if (!phdstudentFulltimeRepository.existsById(id)) {

            throw new UserNotFoundException(id);
        }
        phdstudentFulltimeRepository.deleteById(id);
        return "User with id "+id+" has been deleted success.";
    }
//    @PostMapping("/{id}/report-issue")
//    public ResponseEntity<String> reportIssue(
//            @PathVariable Long id,
//            @RequestParam String issueDescription) {
//        try {
//            Phdftstudent phdftstudent = phdstudentFulltimeRepository.findById(id)
//                    .orElseThrow(() -> new EntityNotFoundException("Phdftstudent not found with id: " + id));
//
//            // Assuming you have a property in Phdftstudent to store issues
//            phdftstudent.setIssueDescription(issueDescription);
//
//            // Save the updated Phdftstudent entity
//            phdstudentFulltimeRepository.save(phdftstudent);
//
//            return ResponseEntity.ok("Issue reported successfully.");
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body("Error reporting issue: " + e.getMessage());
//        }
//    }

}
