package com.platoons.e_commerce.controller;

import com.platoons.e_commerce.dto.CreateUserRequestDto;
import com.platoons.e_commerce.dto.CustomerDto;
import com.platoons.e_commerce.dto.GenericResponseDto;
import com.platoons.e_commerce.dto.UpdateCustomerRequestDto;
import com.platoons.e_commerce.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final ICustomerService customerService;

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> fetchCustomer(@PathVariable String customerId){
        log.info("Fetching customer");

        return ResponseEntity.ok(customerService.fetchCustomer(customerId));
    }

    @PostMapping
    public ResponseEntity<GenericResponseDto> createCustomer(
            @RequestBody CreateUserRequestDto customerDto
    ){
        log.info("Creating customer");

        String customerId = customerService.createCustomer(customerDto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/v1/customer/{id}")
                .build(String.valueOf(customerId));

        log.info("Customer created with id {}", customerId);

        return ResponseEntity.created(uri).body(
                new GenericResponseDto("Successfully created customer"));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable String customerId){
        log.info("Deleting customer");

        customerService.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<GenericResponseDto> updateCustomer(
            @RequestBody UpdateCustomerRequestDto customerDto, @PathVariable String customerId){
        log.info("Updating customer");

        String savedCustomerId = customerService.updateCustomer(customerDto, customerId);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/v1/customer/{id}")
                .build(String.valueOf(savedCustomerId));

        log.info("Customer updated with id {}", savedCustomerId);

        return ResponseEntity.created(uri).body(
                new GenericResponseDto("Successfully updated customer"));
    }
}
