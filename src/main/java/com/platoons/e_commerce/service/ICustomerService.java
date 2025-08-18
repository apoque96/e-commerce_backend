package com.platoons.e_commerce.service;

import com.platoons.e_commerce.dto.CreateUserRequestDto;
import com.platoons.e_commerce.dto.CustomerDto;

public interface ICustomerService {
    String createCustomer(CreateUserRequestDto userDto);
    CustomerDto fetchCustomer(String customerId);
}
