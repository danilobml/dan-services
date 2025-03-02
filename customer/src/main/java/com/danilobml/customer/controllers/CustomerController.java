package com.danilobml.customer.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danilobml.customer.models.CustomerRegistrationRequest;
import com.danilobml.customer.services.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerregistrationRequest) {
        log.info("new customer registration {}", customerregistrationRequest);
        customerService.registerCustomer(customerregistrationRequest);
    }
    
}
