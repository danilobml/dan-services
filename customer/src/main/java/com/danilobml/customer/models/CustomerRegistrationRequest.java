package com.danilobml.customer.models;

public record CustomerRegistrationRequest(
    String firstName,
    String lastName,
    String email) {}
