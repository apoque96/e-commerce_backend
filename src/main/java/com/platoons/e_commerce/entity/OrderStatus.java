package com.platoons.e_commerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_status")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderStatus extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusId;

    // Nombre del estado (PENDING, PAID, SHIPPED, CANCELLED, etc.)
    @NotBlank(message = "Status name is required")
    @Column(length = 50, nullable = false, unique = true)
    private String statusName;

    // Descripción
    @Column(length = 255)
    private String description;
}
