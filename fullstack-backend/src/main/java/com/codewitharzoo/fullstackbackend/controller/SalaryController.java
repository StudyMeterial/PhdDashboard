package com.codewitharzoo.fullstackbackend.controller;

import com.codewitharzoo.fullstackbackend.model.Salary;
import com.codewitharzoo.fullstackbackend.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salaries")
@CrossOrigin("http://localhost:3000")
public class SalaryController {

    @Autowired
    private SalaryRepository salaryRepository;

    // Get all salaries
    @GetMapping
    public List<Salary> getAllSalaries() {
        return salaryRepository.findAll();
    }

    // Get salary by ID
    @GetMapping("/{id}")
    public Salary getSalaryById(@PathVariable Long id) {
        return salaryRepository.findById(id).orElse(null);
    }

    // Create a new salary
    @PostMapping
    public Salary createSalary(@RequestBody Salary salary) {
        return salaryRepository.save(salary);
    }

    // Update an existing salary
    @PutMapping("/{id}")
    public Salary updateSalary(@PathVariable Long id, @RequestBody Salary updatedSalary) {
        Salary existingSalary = salaryRepository.findById(id).orElse(null);
        if (existingSalary != null) {
            existingSalary.setAmount(updatedSalary.getAmount());
            existingSalary.setMonth(updatedSalary.getMonth());
            existingSalary.setYear(updatedSalary.getYear());
            existingSalary.setEmployeeName(updatedSalary.getEmployeeName());
            // Set other fields as needed

            return salaryRepository.save(existingSalary);
        } else {
            return null; // Handle not found scenario
        }
    }

    // Delete a salary by ID
    @DeleteMapping("/{id}")
    public void deleteSalary(@PathVariable Long id) {
        salaryRepository.deleteById(id);
    }
}
