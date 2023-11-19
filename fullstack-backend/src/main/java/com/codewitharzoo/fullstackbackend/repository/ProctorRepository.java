package com.codewitharzoo.fullstackbackend.repository;

// ProctorRepository.java
import com.codewitharzoo.fullstackbackend.model.Proctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProctorRepository extends JpaRepository<Proctor, Long> {
}

