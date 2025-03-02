package com.danilobml.customer.services;

import org.springframework.stereotype.Service;

import com.danilobml.customer.models.Customer;
import com.danilobml.customer.models.CustomerRegistrationRequest;
import com.danilobml.customer.repositories.CustomerRepository;

@Service
public record CustomerService(CustomerRepository customerRepository) {

    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
        .firstName(customerRegistrationRequest.firstName())
        .lastName(customerRegistrationRequest.lastName())
        .email(customerRegistrationRequest.email())
        .build();        

        customerRepository.save(customer);
    }
    
}
