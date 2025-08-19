package com.platoons.e_commerce.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    name = "address",
    indexes = {
        @Index(name = "idx_address_customer", columnList = "customer_id")
    }
)
@AttributeOverrides({
    @AttributeOverride(name = "createdAt", column = @Column(name = "created_at", updatable = false)),
    @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at")),
    @AttributeOverride(name = "deletedAt", column = @Column(name = "deleted_at"))
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    // FK → Customer
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "customer_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_address_customer")
    )
    @NotNull
    private Customer customer;

    // Street address
    @NotBlank(message = "Street address is required")
    @Column(name = "street_address", length = 255, nullable = false)
    private String streetAddress;

    // Zip code
    @NotBlank(message = "Zip code is required")
    @Column(name = "zip_code", length = 20, nullable = false)
    private String zipCode;

    // City
    @NotBlank(message = "City is required")
    @Column(name = "city", length = 100, nullable = false)
    private String city;

    // Country
    @NotBlank(message = "Country is required")
    @Column(name = "country", length = 100, nullable = false)
    private String country;

    // State / Province
    @NotBlank(message = "State/Province is required")
    @Column(name = "state", length = 100, nullable = false)
    private String state;

    // Address type (e.g., HOME, WORK, BILLING, SHIPPING)
    @NotBlank(message = "Address type is required")
    @Column(name = "address_type", length = 50, nullable = false)
    private String addressType;
}

