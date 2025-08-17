package com.platoons.e_commerce.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateProductRequestDto {
    @NotNull(message = "Name is required")
    @NotBlank(message = "Name is required")
    private String name;

    private double discount;

    private String measurements;

    @NotNull(message = "Description is required")
    @NotBlank(message = "Description is required")
    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price must be greater than 0")
    private double price;

    @NotNull(message = "Stock quantity is required")
    private int stockQuantity;

    @NotNull(message = "Category is required")
    private Long categoryId;

    private List<String> colors;
}
