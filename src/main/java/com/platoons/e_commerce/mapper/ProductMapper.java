package com.platoons.e_commerce.mapper;

import com.platoons.e_commerce.dto.CreateProductRequestDto;
import com.platoons.e_commerce.dto.FetchProductResponseDto;
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

    public static FetchProductResponseDto mapProductToFetchProductResponseDto(
            Product product, FetchProductResponseDto fetchProductResponseDto) {
        fetchProductResponseDto.setProductId(product.getProductId());
        fetchProductResponseDto.setCategory(product.getCategory().getName());
        fetchProductResponseDto.setPrice(product.getPrice());
        fetchProductResponseDto.setStockQuantity(product.getStockQuantity());

        // Turn product images into product image dto
        fetchProductResponseDto.setProductImages(
                product.getProductImages().stream()
                        .map(ProductImageMapper::mapProductImageToProductImageDto)
                        .toList());

        fetchProductResponseDto.setName(product.getName());
        fetchProductResponseDto.setDiscount(product.getDiscount());
        fetchProductResponseDto.setDiscountAmount(product.getDiscountAmount());
        fetchProductResponseDto.setMeasurements(product.getMeasurements());
        fetchProductResponseDto.setDescription(product.getDescription());
        fetchProductResponseDto.setPackaging(product.getExtraInfo().getPackaging());
        fetchProductResponseDto.setWeight(product.getExtraInfo().getWeight());
        fetchProductResponseDto.setHeight(product.getExtraInfo().getHeight());
        fetchProductResponseDto.setWidth(product.getExtraInfo().getWidth());
        fetchProductResponseDto.setInformation(product.getExtraInfo().getInformation());
        fetchProductResponseDto.setCreatedAt(product.getCreatedAt());
        fetchProductResponseDto.setUpdatedAt(product.getUpdatedAt());
        fetchProductResponseDto.setDeletedAt(product.getDeletedAt());
        return fetchProductResponseDto;
    }
}
