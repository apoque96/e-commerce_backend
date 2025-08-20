package com.platoons.e_commerce.repository;

import com.platoons.e_commerce.entity.PaymentStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentStatusRepository extends CrudRepository<PaymentStatus, Long> {

    // Buscar un estado de pago por ID
    Optional<PaymentStatus> findByStatusId(Long statusId);
}
