package com.danilobml.fraud.services;

import com.danilobml.fraud.repositories.FraudCheckHistoryRepository;
import com.danilobml.fraud.repositories.FraudsterRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.danilobml.fraud.models.FraudCheckHistory;

@Slf4j
@AllArgsConstructor
@Service
public class FraudCheckHistoryService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;
    private final FraudsterRepository fraudsterRepository;

    public boolean isFraudulentCustomer(String customerEmail) {

        // Checks in history database:
        if(isFraudsterInHistory(customerEmail)) {
            log.info("Customer identified as fraudster in our history.");
            return true;
        }

        // Simulates external API call:
        if (isFraudsterAtExternalApi(customerEmail)) {
            FraudCheckHistory history = FraudCheckHistory.builder()
                    .email(customerEmail)
                    .createdAt(LocalDateTime.now())
                    .isFrausdster(true)
                    .build();
            fraudCheckHistoryRepository.save(history);
            log.info("Customer identified as fraudster in external API");
            return true;
        }

        if (!fraudCheckHistoryRepository.existsByEmail(customerEmail)) {
            FraudCheckHistory history = FraudCheckHistory.builder()
                    .email(customerEmail)
                    .createdAt(LocalDateTime.now())
                    .isFrausdster(false)
                    .build();
            fraudCheckHistoryRepository.save(history);
        }

        return false;

    }

    private boolean isFraudsterInHistory(String email) {
        Optional<FraudCheckHistory> customerHistory = fraudCheckHistoryRepository.findByEmail(email);
        if(customerHistory.isEmpty()) {
            return false;
        }
        return customerHistory.get().getIsFrausdster();
    }

    // Simulates external API call:
    private boolean isFraudsterAtExternalApi(String email) {
        return fraudsterRepository.existsByEmail(email);
    }

}
