package com.danilobml.fraud.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.danilobml.fraud.models.Fraudster;
import com.danilobml.fraud.repositories.FraudsterRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FraudsterService {
    
    private final FraudsterRepository fraudsterRepository;

    public List<Fraudster> findAllFraudsters() {
        return fraudsterRepository.findAll();
    }

    public void registerFraudsterEmail(String email) {
        Fraudster newFraudster = Fraudster.builder()
            .email(email)
            .build();
        fraudsterRepository.save(newFraudster);
    }

}
