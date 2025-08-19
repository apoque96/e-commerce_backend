package com.platoons.e_commerce.service.impl;

import com.platoons.e_commerce.dto.CreateUserRequestDto;
import com.platoons.e_commerce.dto.CustomerDto;
import com.platoons.e_commerce.dto.UpdateCustomerRequestDto;
import com.platoons.e_commerce.entity.Customer;
import com.platoons.e_commerce.exceptions.EntityNotFoundException;
import com.platoons.e_commerce.mapper.CustomerMapper;
import com.platoons.e_commerce.repository.CustomerRepository;
import com.platoons.e_commerce.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public String createCustomer(CreateUserRequestDto customerDto) {
        Customer customer =
                CustomerMapper.mapCreateUserRequestDtoToCustomer(customerDto, new Customer());

        var savedCustomer = customerRepository.save(customer);

        return savedCustomer.getCustomerId();
    }

    @Override
    public CustomerDto fetchCustomer(String customerId) {
        var savedCustomer = customerRepository.findByCustomerIdAndDeletedAtIsNull(customerId)
                .orElseThrow(() -> new EntityNotFoundException("customer", "customerId", customerId));
        
        return CustomerMapper.mapCustomerToCustomerDto(savedCustomer, new CustomerDto());
    }

    @Override
    public void deleteCustomer(String customerId) {
        var optionalCustomer = customerRepository.findById(customerId);

        // Early return for customers that don't exist
        if(optionalCustomer.isEmpty())
            return;

        var savedCustomer = optionalCustomer.get();
        savedCustomer.setDeletedAt(LocalDateTime.now());
        customerRepository.save(savedCustomer);
    }

    @Override
    public String updateCustomer(UpdateCustomerRequestDto customerDto, String customerId) {
        Customer customer =
                customerRepository.findByCustomerIdAndDeletedAtIsNull(customerId)
                        .orElseThrow(() -> new EntityNotFoundException("customer", "customerId", customerId));

        CustomerMapper.mapUpdateCustomerRequestDtoToCustomer(customerDto, customer);

        return customer.getCustomerId();
    }
}
