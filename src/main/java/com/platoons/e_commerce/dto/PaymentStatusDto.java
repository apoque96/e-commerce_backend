package com.platoons.e_commerce.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class PaymentStatusDto {

    private Long statusId;

    private String name;

    private String description;
}
