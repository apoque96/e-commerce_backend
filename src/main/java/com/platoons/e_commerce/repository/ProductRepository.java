package com.platoons.e_commerce.repository;

import com.platoons.e_commerce.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
    @Transactional
    Optional<Product> findByProductIdAndDeletedAtIsNull(String productId);
}
