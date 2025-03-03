package com.danilobml.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danilobml.customer.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    
    boolean existsByEmail(String email);

}
