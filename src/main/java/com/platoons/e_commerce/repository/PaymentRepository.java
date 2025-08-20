package com.platoons.e_commerce.repository;

import com.platoons.e_commerce.entity.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, String> {

    // Busca un pago por su ID y que no esté eliminado (soft delete)
    Optional<Payment> findByPaymentIdAndDeletedAtIsNull(String paymentId);


}
