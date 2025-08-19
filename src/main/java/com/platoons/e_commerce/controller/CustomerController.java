package com.platoons.e_commerce.controller;

import com.platoons.e_commerce.dto.CreateUserRequestDto;
import com.platoons.e_commerce.dto.CustomerDto;
import com.platoons.e_commerce.dto.GenericResponseDto;
import com.platoons.e_commerce.service.ICustomerService;
import lombok.AllArgsConstructor;
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
            @RequestBody CreateUserRequestDto userDto
    ){
        log.info("Creating customer");

        String customerId = customerService.createCustomer(userDto);

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
}
