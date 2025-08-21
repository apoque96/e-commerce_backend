package com.platoons.e_commerce.mapper;

import com.platoons.e_commerce.dto.CreatePaymentRequestDto;
import com.platoons.e_commerce.dto.PaymentDto;
import com.platoons.e_commerce.dto.PaymentMethodDto;
import com.platoons.e_commerce.dto.PaymentStatusDto;
import com.platoons.e_commerce.dto.UpdatePaymentDto;
import com.platoons.e_commerce.entity.Payment;
import com.platoons.e_commerce.entity.PaymentMethod;
import com.platoons.e_commerce.entity.PaymentStatus;

public class PaymentMapper {
    public static Payment mapCreatePaymentRequestDtoToPayment(CreatePaymentRequestDto paymentDto, Payment payment) {
        payment.setAmount(paymentDto.getAmount());
        payment.setPaymentDate(paymentDto.getPaymentDate());
        payment.setBillName(paymentDto.getBillName());
        payment.setDescription(paymentDto.getDescription());
        return payment;
    }

    public static PaymentDto mapPaymentToPaymentDto(Payment payment, PaymentDto paymentDto) {
        paymentDto.setPaymentId(payment.getPaymentId());
        paymentDto.setAmount(payment.getAmount());
        paymentDto.setPaymentDate(payment.getPaymentDate());
        paymentDto.setBillName(payment.getBillName());
        paymentDto.setDescription(payment.getDescription());

        PaymentMethodDto methodDto = new PaymentMethodDto();
        methodDto.setMethodId(payment.getPaymentMethod().getMethodId());
        methodDto.setName(payment.getPaymentMethod().getName());
        methodDto.setDescription(payment.getPaymentMethod().getDescription());
        paymentDto.setPaymentMethod(methodDto);

        PaymentStatusDto statusDto = new PaymentStatusDto();
        statusDto.setStatusId(payment.getPaymentStatus().getStatusId());
        statusDto.setName(payment.getPaymentStatus().getName());
        statusDto.setDescription(payment.getPaymentStatus().getDescription());
        paymentDto.setPaymentStatus(statusDto);
        return paymentDto;
    }

    public static Payment mapUpdatePaymentDtoToPayment(UpdatePaymentDto paymentDto, Payment payment) {
        payment.setAmount(paymentDto.getAmount());
        payment.setPaymentDate(paymentDto.getPaymentDate());
        payment.setBillName(paymentDto.getBillName());
        payment.setDescription(paymentDto.getDescription());

        PaymentMethod method = new PaymentMethod();
        method.setMethodId(paymentDto.getMethodId());
        payment.setPaymentMethod(method);

        PaymentStatus status = new PaymentStatus();
        status.setStatusId(paymentDto.getStatusId());
        payment.setPaymentStatus(status);

        return payment;
    }
}
