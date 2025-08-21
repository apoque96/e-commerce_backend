package com.platoons.e_commerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "shipping")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Shipping extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shippingId;

    // FK a Order
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "order_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_shipping_order")
    )
    private Order order;

    // Shipping type 
    @NotBlank(message = "Shipping type is required")
    @Column(length = 50, nullable = false)
    private String shippingType;

    // Shipping price
    @NotNull(message = "Shipping price is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Shipping price cannot be negative")
    private Double shippingPrice;
}
