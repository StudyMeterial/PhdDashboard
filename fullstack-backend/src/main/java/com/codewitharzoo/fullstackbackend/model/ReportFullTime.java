package com.codewitharzoo.fullstackbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class ReportFullTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reporterName;
    private String issueDescription;

    @ManyToOne
    @JoinColumn(name = "phdftstudent_id")
    @JsonBackReference // or @JsonIgnore if using Jackson 2.9 or higher
    private Phdftstudent phdftstudent;

    // Constructors, getters, and setters...

    public ReportFullTime() {
    }

    public ReportFullTime(String reporterName, String issueDescription) {
        this.reporterName = reporterName;
        this.issueDescription = issueDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public Phdftstudent getPhdftstudent() {
        return phdftstudent;
    }

    public void setPhdftstudent(Phdftstudent phdftstudent) {
        this.phdftstudent = phdftstudent;
    }
}
