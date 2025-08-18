package com.platoons.e_commerce.mapper;

import com.platoons.e_commerce.dto.CreateUserRequestDto;
import com.platoons.e_commerce.entity.Customer;

import java.time.LocalDateTime;

public class CustomerMapper {
    public static Customer mapCreateUserRequestDtoToCustomer(CreateUserRequestDto userDto, Customer customer) {
        customer.setUsername(userDto.getUsername());
        customer.setEmail(userDto.getEmail());
        customer.setPasswordHash(userDto.getPassword());
        customer.setFirstName(userDto.getFirstName());
        customer.setLastName(userDto.getLastName());
        customer.setRegistrationDate(LocalDateTime.now());
        return customer;
    }
}
