package com.kn.orderservice.service;

import com.kn.orderservice.dto.CustomerDto;
import com.kn.orderservice.response.GeneralResponse;

public interface CustomerService {
    GeneralResponse createCustomer(CustomerDto customerDto);
}
