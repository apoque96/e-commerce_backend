package com.platoons.e_commerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "coupon")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Coupon{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponId;

    @NotNull
    @Size(min = 3, max = 20, message = "Coupon code must be between 3 and 20 characters long")
    @NotBlank(message = "Coupon code is required")
    @Column(unique = true, updatable = false)
    private String couponCode;

    @NotNull(message = "Discount amount is required")
    @DecimalMin(value = "0.01", message = "Discount amount must be at least 0.01")
    @DecimalMax(value = "100.00", message = "Discount amount must not exceed 100.00")
    private Double discountAmount;
}