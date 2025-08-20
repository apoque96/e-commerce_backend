package com.platoons.e_commerce.dto;

import java.time.LocalDateTime;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class PaymentDto {

    private Long paymentId;

    private Double amount;

    private LocalDateTime paymentDate;

    private String billName;

    private String description;

    private PaymentMethodDto paymentMethod;

    private PaymentStatusDto paymentStatus;
}
