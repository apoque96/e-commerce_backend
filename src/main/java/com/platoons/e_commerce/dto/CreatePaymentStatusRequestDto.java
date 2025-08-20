package com.platoons.e_commerce.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CreatePaymentStatusRequestDto {

    @NotNull(message = "Payment status ID is required")
    private Long statusId;

    @NotNull(message = "Payment status name is required")
    @NotBlank(message = "Payment status name cannot be blank")
    @Size(min = 3, max = 50, message = "Payment status name must be between 3 and 50 characters")
    private String name;

    @Size(max = 255, message = "Description must not exceed 255 characters")
    private String description;
}
