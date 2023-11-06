package com.codewitharzoo.fullstackbackend.repository;

//import com.codewitharzoo.fullstackbackend.model.User;
import com.codewitharzoo.fullstackbackend.model.Admin;
import com.codewitharzoo.fullstackbackend.model.Admission;
//import com.codewitharzoo.fullstackbackend.model.phdstudent_fulltime;
import org.springframework.data.repository.CrudRepository;

public interface admisssionRepository extends CrudRepository<Admission,Long> {
    Admission findByUsername(String username);
}
