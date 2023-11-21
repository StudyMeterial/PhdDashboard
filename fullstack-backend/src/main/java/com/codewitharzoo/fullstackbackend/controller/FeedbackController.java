package com.codewitharzoo.fullstackbackend.controller;

import com.codewitharzoo.fullstackbackend.Service.FeedbackService;
import com.codewitharzoo.fullstackbackend.model.Feedback;
//import com.codewitharzoo.fullstackbackend.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin("http://localhost:3000")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/add")
    public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback) {
        Feedback savedFeedback = feedbackService.addFeedback(feedback);
        return ResponseEntity.ok(savedFeedback);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
        Optional<Feedback> feedback = feedbackService.getFeedbackById(id);
        return feedback.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.ok("Feedback with ID " + id + " deleted successfully");
    }

    // Add other endpoints as needed

    // Example: Get feedback by type
    @GetMapping("/type/{feedbackType}")
    public ResponseEntity<List<Feedback>> getFeedbackByType(@PathVariable String feedbackType) {
        List<Feedback> feedbacks = feedbackService.getFeedbackByType(feedbackType);
        return ResponseEntity.ok(feedbacks);
    }
}
