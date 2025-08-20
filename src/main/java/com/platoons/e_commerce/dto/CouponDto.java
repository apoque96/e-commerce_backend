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

public class CouponDto {

    private Long couponId;

    private String couponCode;

    private Double discountAmount;
}
