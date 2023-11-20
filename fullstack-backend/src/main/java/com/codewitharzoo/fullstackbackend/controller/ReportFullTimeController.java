package com.codewitharzoo.fullstackbackend.controller;

import com.codewitharzoo.fullstackbackend.model.Phdftstudent;
//import com.codewitharzoo.fullstackbackend.model.Report;
//import com.codewitharzoo.fullstackbackend.repository.PhdftstudentRepository;
import com.codewitharzoo.fullstackbackend.model.ReportFullTime;
import com.codewitharzoo.fullstackbackend.repository.Phdstudent_FulltimeRepository;
import com.codewitharzoo.fullstackbackend.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phdftstudents/reports")
@CrossOrigin("http://localhost:3000")

public class ReportFullTimeController {

    @Autowired
    private Phdstudent_FulltimeRepository phdftstudentRepository;

    @Autowired
    private ReportRepository reportRepository;

    // Endpoint to get all reports for a specific Phdftstudent
    @GetMapping("/{phdftstudentId}")
    public ResponseEntity<List<ReportFullTime>> getAllReportsByPhdftstudent(@PathVariable Long phdftstudentId) {
        Phdftstudent phdftstudent = phdftstudentRepository.findById(phdftstudentId)
                .orElse(null);

        if (phdftstudent == null) {
            return ResponseEntity.notFound().build();
        }

        List<ReportFullTime> reports = phdftstudent.getReports();
        return ResponseEntity.ok(reports);
    }

    // Endpoint to submit a report for a specific Phdftstudent
    @PostMapping("/submit/{phdftstudentId}")
    public ResponseEntity<String> submitReport(
            @PathVariable Long phdftstudentId,
            @RequestBody ReportFullTime report) {

        Phdftstudent phdftstudent = phdftstudentRepository.findById(phdftstudentId)
                .orElse(null);

        if (phdftstudent == null) {
            return ResponseEntity.notFound().build();
        }

        report.setPhdftstudent(phdftstudent);
        reportRepository.save(report);

        return ResponseEntity.ok("Report submitted successfully.");
    }
}
