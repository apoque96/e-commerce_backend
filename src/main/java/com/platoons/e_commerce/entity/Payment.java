package com.platoons.e_commerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    // 🔹 Relaciones
    @OneToOne
    @JoinColumn(name = "method_id")
    private PaymentMethod paymentMethod;

    @OneToOne
    @JoinColumn(name = "status_id")
    private PaymentStatus paymentStatus;
}
