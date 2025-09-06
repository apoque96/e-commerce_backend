package com.platoons.e_commerce.repository;

import java.time.Instant;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.platoons.e_commerce.entity.Product;

import jakarta.transaction.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    // Proyección con los campos que pide la respuesta
    interface ProductSummaryProjection {
        String getProductId();
        Double getPrice();
        Double getDiscountPercentage();
        Double getDiscountedPrice();
        Double getRating();
        Boolean getWishlisted();
        String getProductName();
        String getImageUrl();
        String getImageName();
        Instant getCreatedAt();
    }

    // JPQL con promedio de rating (AVG) y cálculo de precio con descuento
    @Query("""
        select 
          p.productId as productId,
          p.price as price,
          p.discountPercentage as discountPercentage,
          (p.price - (p.price * (p.discountPercentage / 100.0))) as discountedPrice,
          coalesce(avg(r.rating), 0) as rating,
          false as wishlisted,
          p.name as productName,
          (select i.url from ProductImage i where i.product = p and i.isMain = true) as imageUrl,
          (select i.name from ProductImage i where i.product = p and i.isMain = true) as imageName,
          p.createdAt as createdAt
        from Product p
        left join p.reviews r
        where p.deletedAt is null
        group by p.productId, p.price, p.discountPercentage, p.name, p.createdAt
        """)
    Page<ProductSummaryProjection> findAllSummaries(Pageable pageable);

    @Transactional
    Optional<Product> findByProductIdAndDeletedAtIsNull(String productId);
}
