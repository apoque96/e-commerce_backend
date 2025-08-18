package com.platoons.e_commerce.service;

import com.platoons.e_commerce.dto.CreateProductRequestDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface IProductService {
    String createProduct(
            MultipartFile[] images, CreateProductRequestDto productDto);
    void deleteProduct(String productId);
}
