package com.danilobml.fraud.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danilobml.fraud.services.FraudCheckHistoryService;

@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudController(FraudCheckHistoryService fraudCheckHistoryService) {
    
    @GetMapping(path = "{customerId}")
    public boolean isFraudster(@PathVariable Integer userId) {
        return fraudCheckHistoryService.isFraudulentCustomer(userId);
    }

}
