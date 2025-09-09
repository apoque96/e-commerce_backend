package com.platoons.e_commerce;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import com.platoons.e_commerce.dto.CreateUserRequestDto;
import com.platoons.e_commerce.dto.CustomerDto;
import com.platoons.e_commerce.dto.UpdateCustomerRequestDto;
import com.platoons.e_commerce.entity.Customer;
import com.platoons.e_commerce.mapper.CustomerMapper;

@ActiveProfiles("test")
public class CustomerMapperTests {

    @Test
    void testMapCreateUserRequestDtoToCustomer() {
        CreateUserRequestDto dto = new CreateUserRequestDto();
        dto.setUsername("jdoe");
        dto.setEmail("jdoe@example.com");
        dto.setPassword("password123");
        dto.setFirstName("John");
        dto.setLastName("Doe");

        Customer customer = new Customer();

        Customer result = CustomerMapper.mapCreateUserRequestDtoToCustomer(dto, customer);

        assertEquals("jdoe", result.getUsername());
        assertEquals("jdoe@example.com", result.getEmail());
        assertEquals("password123", result.getPasswordHash());
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
    }

    @Test
    void testMapCustomerToCustomerDto() {
        Customer customer = new Customer();
        customer.setCustomerId("1L");
        customer.setRegistrationDate(LocalDateTime.of(2025, 9, 2, 17, 19, 0));
        customer.setUsername("jdoe");
        customer.setEmail("jdoe@example.com");
        customer.setPhoneNumber("5555-5555");
        customer.setFirstName("John");
        customer.setLastName("Doe");

        CustomerDto dto = new CustomerDto();

        CustomerDto result = CustomerMapper.mapCustomerToCustomerDto(customer, dto);

        assertEquals("1L", result.getCustomerId());
        assertEquals(LocalDateTime.of(2025, 9, 2, 17, 19, 0), result.getRegistrationDate());
        assertEquals("jdoe", result.getUsername());
        assertEquals("jdoe@example.com", result.getEmail());
        assertEquals("5555-5555", result.getPhoneNumber());
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());

    }

    @Test
    void testMapUpdateCustomerRequestDtoToCustomer() {
        UpdateCustomerRequestDto dto = new UpdateCustomerRequestDto();
        dto.setUsername("newuser");
        dto.setEmail("new@example.com");
        dto.setPassword("newpass");
        dto.setPhoneNumber("555-9999");
        dto.setFirstName("Jane");
        dto.setLastName("Smith");
        Customer customer = new Customer();
        customer.setCustomerId("2L");
        customer.setRegistrationDate(LocalDateTime.of(2023, 1, 1, 10, 0));

        Customer result = CustomerMapper.mapUpdateCustomerRequestDtoToCustomer(dto, customer);

        assertEquals("newuser", result.getUsername());
        assertEquals("new@example.com", result.getEmail());
        assertEquals("newpass", result.getPasswordHash());
        assertEquals("555-9999", result.getPhoneNumber());
        assertEquals("Jane", result.getFirstName());
        assertEquals("Smith", result.getLastName());

        // Asecurate that we don't erase previous data
        assertEquals("2L", result.getCustomerId());
        assertEquals(LocalDateTime.of(2023, 1, 1, 10, 0), result.getRegistrationDate());
    }
}