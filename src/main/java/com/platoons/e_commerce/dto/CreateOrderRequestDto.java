package com.platoons.e_commerce.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateOrderRequestDto {

    @NotNull(message = "Order ID is required")
    private Long orderId;

    @NotNull(message = "Customer ID is required")
    private Long customer;

    private Long couponId;

    @NotNull(message = "Subtotal is required")
    @DecimalMin(value = "0.0", message = "Sub total must be positive")
    private Double subTotalAmount;

    @NotNull(message = "Total is required")
    @DecimalMin(value = "0.0", message = "Total must be positive")
    private Double totalAmout;
}
