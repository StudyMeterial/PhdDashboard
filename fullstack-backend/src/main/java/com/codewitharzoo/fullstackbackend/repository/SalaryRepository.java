package com.codewitharzoo.fullstackbackend.repository;


import com.codewitharzoo.fullstackbackend.model.Salary;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SalaryRepository extends CrudRepository<Salary, Long> {
    List<Salary> findByEmployeeId(Long employeeId);
    // Custom queries if needed
}