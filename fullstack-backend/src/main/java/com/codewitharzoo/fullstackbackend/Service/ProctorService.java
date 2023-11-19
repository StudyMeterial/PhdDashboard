package com.codewitharzoo.fullstackbackend.Service;

import com.codewitharzoo.fullstackbackend.model.Proctor;

import java.util.List;
// ProctorService.java
import java.util.List;

public interface ProctorService {
    List<Proctor> getAllProctors();
    Proctor getProctorById(Long id);
    Proctor saveProctor(Proctor proctor);
    void deleteProctor(Long id);
}
