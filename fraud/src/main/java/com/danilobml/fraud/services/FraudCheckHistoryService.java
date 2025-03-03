package com.danilobml.fraud.services;

import com.danilobml.fraud.repositories.FraudCheckHistoryRepository;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.danilobml.fraud.data.FraudsterListMock;
import com.danilobml.fraud.models.FraudCheckHistory;

@Service
public record FraudCheckHistoryService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
    
    public boolean isFraudulentCustomer(Integer customerId) {
        if (FraudsterListMock.fraudstersIds.contains(customerId)) {
            FraudCheckHistory history = FraudCheckHistory.builder()
                .customerId(customerId)
                .createdAt(LocalDateTime.now())
                .isFrausdster(true)
                .build();
            fraudCheckHistoryRepository.save(history);
            return true;
        }
        FraudCheckHistory history = FraudCheckHistory.builder()
            .customerId(customerId)
            .createdAt(LocalDateTime.now())
            .isFrausdster(false)
            .build();
        fraudCheckHistoryRepository.save(history);
        return false;
    }

}
