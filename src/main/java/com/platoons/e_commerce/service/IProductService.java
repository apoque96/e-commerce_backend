package com.platoons.e_commerce.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.platoons.e_commerce.dto.CreateProductRequestDto;
import com.platoons.e_commerce.dto.FetchProductResponseDto;
import com.platoons.e_commerce.repository.ProductRepository;

public interface IProductService {
    // NUEVO: listado paginado
    Page<ProductRepository.ProductSummaryProjection> fetchProducts(Pageable pageable);

    // Ya existente: por id
    FetchProductResponseDto fetchProduct(String productId);

    String createProduct(MultipartFile[] images, CreateProductRequestDto productDto);
    void deleteProduct(String productId);
    String updateProduct(MultipartFile[] images, CreateProductRequestDto productDto, String productId);
}
