package com.platoons.e_commerce.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDto {
    private String customerId;

    private LocalDateTime registrationDate;

    private String username;

    private String email;

    private String phoneNumber;

    private String firstName;

    private String lastName;
}
