package com.platoons.e_commerce.repository;

import com.platoons.e_commerce.entity.Customer;
import com.platoons.e_commerce.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {
    Optional<Customer> findByCustomerIdAndDeletedAtIsNull(String productId);
}
