package com.codewitharzoo.fullstackbackend.Service;

import com.codewitharzoo.fullstackbackend.model.Feedback;
import com.codewitharzoo.fullstackbackend.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback addFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Optional<Feedback> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }

    public List<Feedback> getFeedbackByType(String feedbackType) {
        return feedbackRepository.findByFeedbackType(feedbackType);
    }


    // Add other service methods as needed
}
