package com.danilobml.customer.exceptions;

public class CustomerIsFraudsterException extends RuntimeException {
    public CustomerIsFraudsterException(String email) {
        super("Unauthorized operation. Customer with E-mail " + email + " is registered as a fraudster.");
    }
}
