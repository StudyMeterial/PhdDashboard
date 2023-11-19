package com.codewitharzoo.fullstackbackend.repository;

import com.codewitharzoo.fullstackbackend.model.LeaveApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveApplicationRepository extends JpaRepository<LeaveApplication, Long> {
    // You can add custom queries if needed
}
