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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    name = "wishlist",
    uniqueConstraints = @UniqueConstraint(columnNames = "customer_id") // 1:1 con Customer
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
public class Wishlist extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wishlist_id")
    private Long wishlistId;

    // FK → Customer (1:1 garantizado por el unique constraint)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "customer_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_wishlist_customer")
    )
    @NotNull
    private Customer customer;

    @Column(name = "name")
    private String name;
}
