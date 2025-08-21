package com.platoons.e_commerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class OrderProductDto {

    private Long orderProductId;

    private Long product;

    private Long Order;

    private Integer quantity;

    private Double totalPrice;

    private String Color;
}
