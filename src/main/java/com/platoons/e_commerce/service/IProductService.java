package com.platoons.e_commerce.service;

import com.platoons.e_commerce.dto.CreateProductRequestDto;
import com.platoons.e_commerce.dto.FetchProductResponseDto;
import org.springframework.web.multipart.MultipartFile;


public interface IProductService {
    FetchProductResponseDto fetchProduct(String productId);
    String createProduct(
            MultipartFile[] images, CreateProductRequestDto productDto);
    void deleteProduct(String productId);
}
