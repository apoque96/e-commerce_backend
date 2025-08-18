package com.platoons.e_commerce.service;

import com.platoons.e_commerce.dto.CreateUserRequestDto;

public interface ICustomerService {
    String createCustomer(CreateUserRequestDto userDto);
}
