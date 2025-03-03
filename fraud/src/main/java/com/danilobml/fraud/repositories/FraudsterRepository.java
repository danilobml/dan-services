package com.danilobml.fraud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danilobml.fraud.models.Fraudster;

public interface FraudsterRepository extends JpaRepository<Fraudster, Integer> {

    public boolean existsByEmail(String email);

}
