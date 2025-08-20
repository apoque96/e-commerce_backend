package com.platoons.e_commerce.dto;

import java.time.LocalDateTime;
import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CreatePaymentRequestDto {

    @NotNull(message = "Payment ID is required")
    private Long paymentId;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    private Double amount;

    @NotNull(message = "Payment date is required")
    private LocalDateTime paymentDate;

    @NotBlank(message = "Bill name is required")
    @Size(min = 3, max = 100, message = "Bill name must be between 3 and 100 characters")
    private String billName;

    @Size(max = 255, message = "Description must not exceed 255 characters")
    private String description;

    @NotNull(message = "Payment method is required")
    private Long methodId;

    @NotNull(message = "Payment status is required")
    private Long statusId;
}
