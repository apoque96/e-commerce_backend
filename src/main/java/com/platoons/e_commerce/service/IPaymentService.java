package com.platoons.e_commerce.service;

import com.platoons.e_commerce.dto.CreatePaymentRequestDto;
import com.platoons.e_commerce.dto.PaymentDto;
import com.platoons.e_commerce.dto.UpdatePaymentDto;

public interface IPaymentService {
    String createPayment(CreatePaymentRequestDto paymentDto);

    PaymentDto fetchPayment(String paymentId);

    void deletePayment(String paymentId);

    String updatePayment(UpdatePaymentDto paymentDto, String paymentId);
}