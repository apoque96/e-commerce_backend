package com.platoons.e_commerce.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FetchProductResponseDto {
    private String productId;

    private String category;

    private List<ProductImageDto> productImages;

    private String name;

    private double discount;

    private double discountAmount;

    private String measurements;

    private String description;

    private double price;

    private int stockQuantity;

    private String packaging;

    private String weight;

    private String height;

    private String width;

    private String information;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;
}
