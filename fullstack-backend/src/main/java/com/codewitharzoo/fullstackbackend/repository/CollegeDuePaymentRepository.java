package com.codewitharzoo.fullstackbackend.repository;

import com.codewitharzoo.fullstackbackend.model.CollegeDuePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeDuePaymentRepository extends JpaRepository<CollegeDuePayment, Long> {
    // You can add custom queries or methods here if needed
}
