package com.platoons.e_commerce.controller;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.platoons.e_commerce.dto.CreateProductRequestDto;
import com.platoons.e_commerce.dto.FetchProductResponseDto;
import com.platoons.e_commerce.dto.GenericResponseDto;
import com.platoons.e_commerce.repository.ProductRepository;
import com.platoons.e_commerce.service.IProductService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/product")
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final IProductService productService;

    // NUEVO: listado paginado
    @GetMapping
    public ResponseEntity<Page<ProductRepository.ProductSummaryProjection>> fetchProducts(Pageable pageable) {
        log.info("Fetching products page={}, size={}, sort={}", pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
        return ResponseEntity.ok(productService.fetchProducts(pageable));
    }

    // Ya existente: obtener 1 producto por id
    @GetMapping("/{productId}")
    public ResponseEntity<FetchProductResponseDto> fetchProduct(@PathVariable String productId){
        log.info("Fetching product {}", productId);
        return ResponseEntity.ok(productService.fetchProduct(productId));
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<GenericResponseDto> createProduct(
            @RequestPart(name = "image") MultipartFile[] images,
            @Valid @RequestPart(name = "productDto") CreateProductRequestDto productDto
    ){
        log.info("Creating product");
        String productId = productService.createProduct(images, productDto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/v1/product/{id}")
                .buildAndExpand(productId)
                .toUri();

        log.info("Product created with id {}", productId);
        return ResponseEntity.created(uri)
                .body(new GenericResponseDto("Successfully created product"));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Object> deleteProduct(@PathVariable String productId){
        log.info("Deleting product {}", productId);
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, path = "/{productId}")
    public ResponseEntity<GenericResponseDto> updateProduct(
            @RequestPart(name = "image") MultipartFile[] images,
            @Valid @RequestPart(name = "productDto") CreateProductRequestDto productDto,
            @PathVariable String productId
    ){
        log.info("Updating product {}", productId);
        String productIdReturned = productService.updateProduct(images, productDto, productId);
        log.info("Updated product with id {}", productIdReturned);
        return ResponseEntity.ok(new GenericResponseDto("Successfully updated product"));
    }
}
