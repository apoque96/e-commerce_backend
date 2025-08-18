package com.platoons.e_commerce.dto;

import com.platoons.e_commerce.entity.Category;
import com.platoons.e_commerce.entity.ExtraInfo;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FetchProductResponseDto {
    private UUID productId;

    private Category category;

    private ExtraInfo extraInfo;

    private List<ProductImageDto> productImages;

    private String name;

    private double discount;

    private double discountAmount;

    private String measurements;

    private String description;

    private String packaging;

    private String weight;

    private String height;

    private String width;

    private String information;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;
}
