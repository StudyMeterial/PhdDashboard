package com.codewitharzoo.fullstackbackend.repository;

import com.codewitharzoo.fullstackbackend.model.AttendanceUser;
import com.codewitharzoo.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceUserRepository extends JpaRepository<AttendanceUser, Long> {
    List<AttendanceUser> findByUser(User user);
}
