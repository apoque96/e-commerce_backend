package com.platoons.e_commerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "extra_info_id")
    private ExtraInfo extraInfo;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<ProductImage> productImages;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID productId;

    @NotNull(message = "Name is required")
    @NotBlank(message = "Name is required")
    private String name;

    private double discount;

    private double discountAmount;

    private String measurements;

    @NotNull(message = "Description is required")
    @NotBlank(message = "Description is required")
    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull(message = "Price is required")
    @Size(min = 0, message = "Price must be greater than 0")
    private double price;

    @NotNull(message = "Stock quantity is required")
    private int stockQuantity;
}
