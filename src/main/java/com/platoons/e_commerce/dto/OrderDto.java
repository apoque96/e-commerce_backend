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

public class OrderDto {

    private Long orderId;

    private Double subTotalAmout;

    private Double totalAmount;

    private CustomerDto customer;

    private CouponDto coupon;
}
