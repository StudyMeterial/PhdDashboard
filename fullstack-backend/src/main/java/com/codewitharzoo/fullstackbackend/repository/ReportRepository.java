package com.codewitharzoo.fullstackbackend.repository;

//import com.codewitharzoo.fullstackbackend.model.Report;
import com.codewitharzoo.fullstackbackend.model.ReportFullTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<ReportFullTime, Long> {
    // You can add custom queries or methods if needed
}
