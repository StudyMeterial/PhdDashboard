package com.codewitharzoo.fullstackbackend.repository;

import com.codewitharzoo.fullstackbackend.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    // Custom query methods if needed
}
