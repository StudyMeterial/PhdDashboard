package com.codewitharzoo.fullstackbackend.implement;
// ProctorServiceImpl.java
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import com.codewitharzoo.fullstackbackend.Service.ProctorService;
import com.codewitharzoo.fullstackbackend.model.Proctor;
import com.codewitharzoo.fullstackbackend.repository.ProctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProctorServiceImpl implements ProctorService {

    @Autowired
    private ProctorRepository proctorRepository;

    @Override
    public List<Proctor> getAllProctors() {
        return proctorRepository.findAll();
    }

    @Override
    public Proctor getProctorById(Long id) {
        Optional<Proctor> optionalProctor = proctorRepository.findById(id);
        return optionalProctor.orElse(null);
    }

    @Override
    public Proctor saveProctor(Proctor proctor) {
        return proctorRepository.save(proctor);
    }

    @Override
    public void deleteProctor(Long id) {
        proctorRepository.deleteById(id);
    }
}
