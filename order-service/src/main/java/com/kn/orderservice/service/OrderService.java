package com.kn.orderservice.service;

import com.kn.orderservice.dto.OrderDto;
import com.kn.orderservice.response.*;

public interface OrderService {
    GeneralResponse createOrder(OrderDto orderDto);
    OrdersResponse getOrdersByDate(String date);
    OrdersByProductResponse getOrdersByProduct(int productId);
    OrdersResponse getOrdersByCustomer(int customerId);
}
