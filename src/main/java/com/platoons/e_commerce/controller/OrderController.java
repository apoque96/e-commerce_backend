package com.platoons.e_commerce.controller;

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

import com.platoons.e_commerce.dto.CreateOrderRequestDto;
import com.platoons.e_commerce.dto.GenericResponseDto;
import com.platoons.e_commerce.dto.OrderDto;
import com.platoons.e_commerce.dto.UpdateOrderDto;
import com.platoons.e_commerce.service.IOrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")

public class OrderController {
    private final IOrderService orderService;

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> fetchOrder(@PathVariable String orderId) {
        log.info("Fetching order");

        return ResponseEntity.ok(orderService.fetchOrder(orderId));
    }

    @PostMapping
    public ResponseEntity<GenericResponseDto> crateOrder(@RequestBody CreateOrderRequestDto orderDto) {
        log.info("Creating Order");
        String orderId = orderService.createOrder(orderDto);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/order")
                .build(String.valueOf(orderId));

        log.info("Order crated with id {}", orderId);

        return ResponseEntity.created(uri).body(new GenericResponseDto("Successfully Order"));
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Object> deleteOrder(@PathVariable String orderId) {
        log.info("Deleting Order");

        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{orderID}")
    public ResponseEntity<GenericResponseDto> updateOrder(@RequestBody UpdateOrderDto orderDto,
            @PathVariable String orderID) {
        log.info("Updating order");

        String savedOrderId = orderService.updateOrder(orderDto, orderID);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/order/{id}")
                .build(String.valueOf(savedOrderId));

        log.info("Order updated with id {}", savedOrderId);

        return ResponseEntity.created(uri).body(new GenericResponseDto("Order Updated"));
    }
}
