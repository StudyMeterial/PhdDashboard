package com.codewitharzoo.fullstackbackend.controller;

import com.codewitharzoo.fullstackbackend.exception.UserNotFoundException;
import com.codewitharzoo.fullstackbackend.model.Phdftstudent;
import com.codewitharzoo.fullstackbackend.model.Salary;
import com.codewitharzoo.fullstackbackend.repository.Phdstudent_FulltimeRepository;
import com.codewitharzoo.fullstackbackend.repository.SalaryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class phdstudent_fulltimeController {


    private  final Phdstudent_FulltimeRepository phdstudentFulltimeRepository;
    private final SalaryRepository salaryRepository;

    public phdstudent_fulltimeController(Phdstudent_FulltimeRepository phdstudentFulltimeRepository, SalaryRepository salaryRepository) {
        this.phdstudentFulltimeRepository = phdstudentFulltimeRepository;
        this.salaryRepository = salaryRepository;
    }


    @PostMapping("/phdstudentft")
    public ResponseEntity<?> submitAdmission(@RequestBody Phdftstudent phdftstudent) {
        // Validate the admission form data
        if (phdftstudent.getFullname() == null || phdftstudent.getEmail() == null || phdftstudent.getUsername() == null ||
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

    @PostMapping("/{employeeId}/salaries/create")
    public ResponseEntity<Salary> createSalary(@PathVariable Long employeeId, @RequestBody Salary salary) {
        Optional<Phdftstudent> optionalEmployee = phdstudentFulltimeRepository.findById(employeeId);

        if (optionalEmployee.isPresent()) {
            Phdftstudent employee = optionalEmployee.get();
            salary.setEmployee(employee);
            Salary savedSalary = salaryRepository.save(salary);
            return new ResponseEntity<>(savedSalary, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{employeeId}/salaries")
    public ResponseEntity<List<Salary>> getEmployeeSalaries(@PathVariable Long employeeId) {
        List<Salary> salaries = salaryRepository.findByEmployeeId(employeeId);
        return new ResponseEntity<>(salaries, HttpStatus.OK);
    }

}
