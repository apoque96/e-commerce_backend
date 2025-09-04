package com.platoons.e_commerce;

import org.junit.jupiter.api.Test;

import com.platoons.e_commerce.entity.ProductImage;
import com.platoons.e_commerce.dto.ProductImageDto;
import com.platoons.e_commerce.mapper.ProductImageMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductImageMapperTest {

    @Test
    void testmapProductImageToProductImageDto() {
        ProductImage productImage = new ProductImage();
        productImage.setColor("Red");
        productImage.setImageName("img_1");

        ProductImageDto result = ProductImageMapper.mapProductImageToProductImageDto(productImage);

        assertEquals("Red", result.getColor());
        assertEquals("img_1", result.getImageUrl());
    }

}
