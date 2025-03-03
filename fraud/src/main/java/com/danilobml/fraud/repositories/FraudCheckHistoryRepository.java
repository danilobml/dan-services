package com.danilobml.fraud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danilobml.fraud.models.FraudCheckHistory;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer>{
    
}
