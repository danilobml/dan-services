package com.danilobml.fraud.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danilobml.fraud.models.FraudCheckHistory;



public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer>{
    
    Optional<FraudCheckHistory> findByEmail(String email);
    boolean existsByEmail(String email);

}
