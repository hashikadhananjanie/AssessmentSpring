package com.kn.orderservice.service.impl;

import com.kn.orderservice.domain.Customer;
import com.kn.orderservice.domain.Order;
import com.kn.orderservice.domain.OrderLine;
import com.kn.orderservice.domain.Product;
import com.kn.orderservice.dto.OrderDto;
import com.kn.orderservice.repository.OrderLineRepository;
import com.kn.orderservice.repository.OrderRepository;
import com.kn.orderservice.response.*;
import com.kn.orderservice.service.OrderService;
import com.kn.orderservice.util.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderLineRepository orderLineRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public GeneralResponse createOrder(OrderDto orderDto) {

        GeneralResponse response = new GeneralResponse();

        try {

            Order order = new Order().setCustomer(new Customer().setId(orderDto.getCustomerId()))
                    .setSubmissionDate(LocalDate.now());
            Order finalOrder = order;
            orderDto.getOrderLines().stream().map(orderLine ->
                    finalOrder.getOrderLines().add(new OrderLine().setOrder(finalOrder).setProduct(new Product().setId(orderLine.getProductId())).setQuantity(orderLine
                            .getQuantity()))).collect(Collectors.toList());

            orderRepository.save(finalOrder);
            response.setStatusCode(StatusCode.SUCCESS.getErrorCode())
                    .setStatusDesc("Order created successfully");

        }
        catch (Exception e) {
            log.error("Error occurred. Order creation failed");
            response.setStatusCode(StatusCode.UNKNOWN_ERROR.getErrorCode())
                    .setStatusDesc("Order creation failed");
        }
        return response;
    }

    @Override
    public OrdersResponse getOrdersByDate(String date) {

        OrdersResponse response = new OrdersResponse();
        try {
            List<Order> orders = orderRepository.findAllBySubmissionDate(LocalDate.parse(date));
            List<OrderResponse> orderResponses = Arrays.asList(modelMapper.map(orders, OrderResponse[].class));
            response.setOrders(orderResponses).setStatusCode(StatusCode.SUCCESS.getErrorCode());
        }
        catch (Exception e) {
            log.error("Error occurred. Customer creation failed");
            response.setStatusCode(StatusCode.UNKNOWN_ERROR.getErrorCode())
                    .setStatusDesc("Customer creation failed");
        }
        return  response;
    }

    @Override
    public OrdersResponse getOrdersByCustomer(int customerId) {

        OrdersResponse response = new OrdersResponse();
        try {
            List<Order> orders = orderRepository.findAllByCustomer(customerId);
            List<OrderResponse> orderResponses = Arrays.asList(modelMapper.map(orders, OrderResponse[].class));
            response.setOrders(orderResponses).setStatusCode(StatusCode.SUCCESS.getErrorCode());
        }
        catch (Exception e) {
            log.error("Error occurred. Customer creation failed");
            response.setStatusCode(StatusCode.UNKNOWN_ERROR.getErrorCode())
                    .setStatusDesc("Customer creation failed");
        }
        return response;
    }

    @Override
    public OrdersByProductResponse getOrdersByProduct(int productId) {

        OrdersByProductResponse response = new OrdersByProductResponse();
        try {
            List<OrderLine> orderLines = orderLineRepository.findAllByProduct(productId);
            if(!orderLines.isEmpty()) {
                response.setProduct(modelMapper.map(orderLines.get(0).getProduct(), ProductResponse.class));

                List<OrderByProductResponse> orders = orderLines.stream().map(orderLine -> {
                    OrderByProductResponse ord = new OrderByProductResponse();
                    ord.setOrderId(orderLine.getOrder().getId()).setOrderLineId(orderLine.getId())
                            .setQuantity(orderLine.getQuantity())
                            .setOrderDate(orderLine.getOrder().getSubmissionDate())
                            .setCustomer(modelMapper.map(orderLine.getOrder().getCustomer(), CustomerResponse.class));
                    return ord;
                }).collect(Collectors.toList());

                response.setOrders(orders);
            }
            else {
                response.setStatusCode(StatusCode.ORDERS_NOT_FOUND.getErrorCode())
                        .setStatusDesc("No orders found for the given product");
            }
        }
        catch (Exception e) {
            log.error("Error occurred. Customer creation failed");
            response.setStatusCode(StatusCode.UNKNOWN_ERROR.getErrorCode())
                    .setStatusDesc("Customer creation failed");
        }
        return response;
    }

}
