package com.danilobml.customer.validation;

import com.danilobml.customer.repositories.CustomerRepository;

import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@AllArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private CustomerRepository customerRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return !customerRepository.existsByEmail(email);
    }
}