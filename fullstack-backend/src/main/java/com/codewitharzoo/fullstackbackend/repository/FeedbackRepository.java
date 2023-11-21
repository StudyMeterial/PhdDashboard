package com.codewitharzoo.fullstackbackend.repository;

import com.codewitharzoo.fullstackbackend.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByFeedbackType(String feedbackType);
    // You can add custom query methods if needed
}
