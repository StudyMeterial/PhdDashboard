package com.codewitharzoo.fullstackbackend.repository;

import com.codewitharzoo.fullstackbackend.model.AssignmentUser;
import com.codewitharzoo.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentUserRepository extends JpaRepository<AssignmentUser, Long> {
    List<AssignmentUser> findByUser(User user);
}
