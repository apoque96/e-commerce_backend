package com.platoons.e_commerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    private Double amount;

    @NotNull(message = "Payment date is required")
    private LocalDateTime paymentDate;

    @NotNull(message = "Created date is required")
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    @NotBlank(message = "Bill name is required")
    @Size(min = 3, max = 100, message = "Bill name must be between 3 and 100 characters")
    private String billName;

    @Size(max = 255, message = "Description must not exceed 255 characters")
    private String description;

    // 🔹 Relaciones
    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    @OneToOne
    @JoinColumn(name = "method_id")
    private PaymentMethod paymentMethod;

    @OneToOne
    @JoinColumn(name = "status_id")
    private PaymentStatus paymentStatus;

    @OneToOne
    @JoinColumn(name = "shipping_id")
    private Shipping shipping;
}
