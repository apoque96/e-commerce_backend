package com.platoons.e_commerce.repository;

import com.platoons.e_commerce.entity.ProductImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends CrudRepository<ProductImage, Long> {
}
