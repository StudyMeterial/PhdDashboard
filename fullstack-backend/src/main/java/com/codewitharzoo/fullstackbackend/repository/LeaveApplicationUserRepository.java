package com.codewitharzoo.fullstackbackend.repository;

import com.codewitharzoo.fullstackbackend.model.LeaveApplicationUser;
import com.codewitharzoo.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveApplicationUserRepository extends JpaRepository<LeaveApplicationUser, Long> {

    // Custom query method to find leave applications by user
    List<LeaveApplicationUser> findByUser(User user);
}
