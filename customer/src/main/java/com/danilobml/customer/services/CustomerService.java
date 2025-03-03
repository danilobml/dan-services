package com.danilobml.customer.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.danilobml.customer.dtos.CustomerRegistrationRequestDTO;
import com.danilobml.customer.dtos.FraudCheckResponseDTO;
import com.danilobml.customer.exceptions.CustomerIsFraudsterException;
import com.danilobml.customer.models.Customer;
import com.danilobml.customer.repositories.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    @SuppressWarnings("null")
    public void registerCustomer(CustomerRegistrationRequestDTO customerRegistrationRequest) {
        
        FraudCheckResponseDTO fraudCheckresponse = restTemplate.getForObject(
            "http://localhost:8081/api/v1/fraud-check/{customerEmail}", FraudCheckResponseDTO.class,
                customerRegistrationRequest.getEmail()
            );

        if (fraudCheckresponse.isFrausdster()) {
            throw new CustomerIsFraudsterException(customerRegistrationRequest.getEmail());
        }

        Customer customer = Customer.builder()
        .firstName(customerRegistrationRequest.getFirstName())
        .lastName(customerRegistrationRequest.getLastName())
        .email(customerRegistrationRequest.getEmail())
        .build();
        
        customerRepository.save(customer);
        
    }
    
}
