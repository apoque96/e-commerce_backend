package com.platoons.e_commerce.service;

import com.platoons.e_commerce.dto.CreateUserRequestDto;
import com.platoons.e_commerce.dto.CustomerDto;
import com.platoons.e_commerce.dto.UpdateCustomerRequestDto;

public interface ICustomerService {
    String createCustomer(CreateUserRequestDto customerDto);
    CustomerDto fetchCustomer(String customerId);
    void deleteCustomer(String customerId);
    String updateCustomer(UpdateCustomerRequestDto customerDto, String customerId);
}
