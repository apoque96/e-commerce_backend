package com.platoons.e_commerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment_method")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentMethod extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long methodId;

    @NotNull(message = "Payment method name is required")
    @NotBlank(message = "Payment method name cannot be blank")
    @Size(min = 3, max = 50, message = "Payment method name must be between 3 and 50 characters")
    @Column(unique = true)
    private String name;

    @Size(max = 255, message = "Description must not exceed 255 characters")
    private String description;
}
