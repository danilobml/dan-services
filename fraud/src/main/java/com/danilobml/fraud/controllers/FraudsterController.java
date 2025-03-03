package com.danilobml.fraud.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.danilobml.fraud.dtos.RegisterFraudsterDTO;
import com.danilobml.fraud.models.Fraudster;
import com.danilobml.fraud.services.FraudsterService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.GetMapping;


@AllArgsConstructor
@RestController
@RequestMapping("api/v1/fraudster")
public class FraudsterController {

    private final FraudsterService fraudsterService;

    @GetMapping("")
    public List<Fraudster> getListOfFraudsters() {
        return fraudsterService.findAllFraudsters();
    }    
    
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerNewFraudsterEmail(@RequestBody RegisterFraudsterDTO registerFraudsterDTO) {
        fraudsterService.registerFraudsterEmail(registerFraudsterDTO.getEmail());
    }
    
}