package com.platoons.e_commerce.controller;

import com.platoons.e_commerce.dto.CreateProductRequestDto;
import com.platoons.e_commerce.dto.GenericResponseDto;
import com.platoons.e_commerce.service.IProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/product")
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final IProductService productService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<GenericResponseDto> createProduct(
            @RequestPart(name = "image") MultipartFile[] images,
            @Valid @RequestPart CreateProductRequestDto productDto
            ){
        log.info("Creating product");

        String productId = productService.createProduct(
                images, productDto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/v1/product/{id}")
                .build(String.valueOf(productId));

        log.info("Product created with id {}", productId);
        return ResponseEntity.created(uri).body(
                new GenericResponseDto("Successfully created product"));
    }
}
