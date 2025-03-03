package com.danilobml.customer.controllers;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danilobml.customer.dtos.CustomerRegistrationRequestDTO;
import com.danilobml.customer.services.CustomerService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Validated
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private CustomerService customerService;

    @PostMapping
    public void registerCustomer(@Valid @RequestBody CustomerRegistrationRequestDTO customerregistrationRequest) {
        log.info("new customer registration {}", customerregistrationRequest);
        
        customerService.registerCustomer(customerregistrationRequest);
    }
    
}
