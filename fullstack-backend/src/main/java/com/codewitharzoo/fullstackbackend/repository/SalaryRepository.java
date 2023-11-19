package com.codewitharzoo.fullstackbackend.repository;

import com.codewitharzoo.fullstackbackend.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
    // You can add custom query methods here if needed
}
