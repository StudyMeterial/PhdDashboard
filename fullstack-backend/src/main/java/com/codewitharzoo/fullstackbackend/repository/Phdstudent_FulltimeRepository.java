package com.codewitharzoo.fullstackbackend.repository;

//import com.codewitharzoo.fullstackbackend.model.User;
import com.codewitharzoo.fullstackbackend.model.Admin;
import com.codewitharzoo.fullstackbackend.model.Phdftstudent;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface Phdstudent_FulltimeRepository extends CrudRepository<Phdftstudent,Long> {
    Phdftstudent findByUsername(String username);

    Optional<Phdftstudent> findByUsernameAndPassword(String username, String password);
}
