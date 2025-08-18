package com.platoons.e_commerce.mapper;

import com.platoons.e_commerce.dto.ProductImageDto;

public class ProductImageMapper {
    public static ProductImageDto mapProductImageToProductImageDto(
            com.platoons.e_commerce.entity.ProductImage productImage) {
        ProductImageDto productImageDto = new ProductImageDto();
        productImageDto.setColor(productImage.getColor());
        productImageDto.setImageUrl(productImage.getImageName());
        return productImageDto;
    }
}
