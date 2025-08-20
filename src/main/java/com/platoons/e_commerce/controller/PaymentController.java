package com.platoons.e_commerce.controller;

import com.platoons.e_commerce.dto.CreatePaymentRequestDto;
import com.platoons.e_commerce.dto.PaymentDto;
import com.platoons.e_commerce.dto.GenericResponseDto;
import com.platoons.e_commerce.dto.UpdatePaymentDto;
import com.platoons.e_commerce.service.IPaymentService;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/payment")
public class PaymentController {
    private final IPaymentService paymentService;

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentDto> fetchPayment(@PathVariable Long paymentId) {
        log.info("Fetching payment");

        return ResponseEntity.ok(paymentService.fetchPayment(paymentId));
    }

    @PostMapping
    public ResponseEntity<GenericResponseDto> createPayment(@RequestBody CreatePaymentRequestDto paymentDto) {
        log.info("Creating Payment");
        String paymentId = paymentService.createPayment(paymentDto);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/payment/{id}")
                .build(String.valueOf(paymentId));

        log.info("Payment created with id {}", paymentId);

        return ResponseEntity.created(uri).body(new GenericResponseDto("Successful Payment"));
    }

    @DeleteMapping("/{paymentId}")
    public ResponseEntity<Object> deletePayment(@PathVariable Long paymentId) {
        log.info("Deleting Payment");

        paymentService.deletePayment(paymentId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{paymentId}")
    public ResponseEntity<GenericResponseDto> updatePayment(@RequestBody UpdatePaymentDto paymentDto,
            @PathVariable Long paymentId) {
        log.info("Updating Payment");

        String savedPaymentid = paymentService.updatePayment(paymentDto, paymentId);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/payment/{id}")
                .build(String.valueOf(savedPaymentid));

        log.info("Payment updated with id {}", savedPaymentid);

        return ResponseEntity.created(uri).body(new GenericResponseDto(" Payment updated"));
    }

}
