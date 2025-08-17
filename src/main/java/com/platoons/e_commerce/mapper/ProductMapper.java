package com.platoons.e_commerce.mapper;

import com.platoons.e_commerce.dto.CreateProductRequestDto;
import com.platoons.e_commerce.entity.Product;

public class ProductMapper {
    public static Product mapCreateProductRequestDtoToProduct(
            CreateProductRequestDto productDto, Product product) {
        product.setName(productDto.getName());
        product.setDiscount(productDto.getDiscount());
        product.setDiscountAmount(productDto.getDiscount()*productDto.getPrice());
        product.setMeasurements(productDto.getMeasurements());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setStockQuantity(productDto.getStockQuantity());
        return product;
    }
}
