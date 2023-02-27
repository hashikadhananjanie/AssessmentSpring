package com.kn.orderservice.controller;

import com.kn.orderservice.dto.OrderDto;
import com.kn.orderservice.response.*;
import com.kn.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.status;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/order", produces = { APPLICATION_JSON_VALUE })
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<GeneralResponse> createOrder(@RequestBody OrderDto orderDto) {
        return status(HttpStatus.OK).body(orderService.createOrder(orderDto));
    }

    @GetMapping("/get-orders-by-date")
    public ResponseEntity<OrdersResponse> getOrdersByDate(
            @RequestParam(value = "date") String date) {
        return status(HttpStatus.OK).body(orderService.getOrdersByDate(date));
    }

    @GetMapping("/get-orders-by-product/{productId}")
    public ResponseEntity<OrdersByProductResponse> getOrdersByProduct(
            @PathVariable(value = "productId") int productId) {
        return status(HttpStatus.OK).body(orderService.getOrdersByProduct(productId));
    }

    @GetMapping("/get-orders-by-customer/{customerId}")
    public ResponseEntity<OrdersResponse> getOrdersByCustomer(
            @PathVariable(value = "customerId") int customerId) {
        return status(HttpStatus.OK).body(orderService.getOrdersByCustomer(customerId));
    }

}
