package com.danilobml.fraud.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danilobml.fraud.dtos.FraudCheckResponseDTO;
import com.danilobml.fraud.services.FraudCheckHistoryService;

@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudCheckController(FraudCheckHistoryService fraudCheckHistoryService) {
    
    @GetMapping(path = "{customerEmail}")
    public FraudCheckResponseDTO isFraudster(@PathVariable String customerEmail) {
        FraudCheckResponseDTO fraudCheckResponse = new FraudCheckResponseDTO(fraudCheckHistoryService.isFraudulentCustomer(customerEmail));
        return fraudCheckResponse;
    }

}
