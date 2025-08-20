package com.platoons.e_commerce.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CreatePaymentMethodRequestDto {

    @NotNull(message = "Payment method ID is required")
    private Long methodId;

    @NotNull(message = "Payment method name is required")
    @NotBlank(message = "Payment method name cannot be blank")
    @Size(min = 3, max = 50, message = "Payment method name must be between 3 and 50 characters")
    private String name;

    @Size(max = 255, message = "Description must not exceed 255 characters")
    private String description;
}
