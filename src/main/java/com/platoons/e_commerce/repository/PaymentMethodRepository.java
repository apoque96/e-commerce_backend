package com.platoons.e_commerce.repository;

import com.platoons.e_commerce.entity.PaymentMethod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Long> {

    // Buscar un método de pago por ID
    Optional<PaymentMethod> findByMethodId(Long methodId);
}
