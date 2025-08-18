package com.platoons.e_commerce.controller;

import com.platoons.e_commerce.dto.CreateProductRequestDto;
import com.platoons.e_commerce.dto.FetchProductResponseDto;
import com.platoons.e_commerce.dto.GenericResponseDto;
import com.platoons.e_commerce.service.IProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{productId}")
    public ResponseEntity<FetchProductResponseDto> fetchProduct(@PathVariable String productId){
        log.info("Fetching product");

        return ResponseEntity.ok(productService.fetchProduct(productId));
    }

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

    @DeleteMapping("/{productId}")
    public ResponseEntity<Object> deleteProduct(@PathVariable String productId){
        log.info("Deleting product");

        productService.deleteProduct(productId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, path = "/{productId}")
    public ResponseEntity<GenericResponseDto> updateProduct(
            @RequestPart(name = "image") MultipartFile[] images,
            @Valid @RequestPart CreateProductRequestDto productDto,
            @PathVariable String productId
    ){
        log.info("Updating product");

        String productIdReturned = productService.updateProduct(
                images, productDto, productId);

        log.info("Updated product with id {}", productIdReturned);
        return ResponseEntity.ok(
                new GenericResponseDto("Successfully updated product"));
    }
}
