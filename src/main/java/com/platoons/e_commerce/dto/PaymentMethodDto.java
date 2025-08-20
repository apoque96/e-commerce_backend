package com.platoons.e_commerce.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PaymentMethodDto {

    private Long methodId;

    private String name;

    private String description;
}
