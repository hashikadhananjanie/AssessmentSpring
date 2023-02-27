package com.kn.orderservice.controller;

import com.kn.orderservice.dto.CustomerDto;
import com.kn.orderservice.response.GeneralResponse;
import com.kn.orderservice.service.CustomerService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerControllerTest {

    @InjectMocks
    CustomerController customerController;

    @Mock
    CustomerService customerService;

    @BeforeAll
    public void initialize() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createCustomerTest(){
        GeneralResponse expected = new GeneralResponse().setStatusDesc("Customer created successfully");
        Mockito.when(customerService.createCustomer(Mockito.any(CustomerDto.class)))
                .thenReturn(expected);
        CustomerDto customerDto = new CustomerDto().setEmail("test@e.com").setEmail("1111111").setFullName("test user");
        ResponseEntity<GeneralResponse> response = customerController.createCustomer(customerDto);
        Assert.assertEquals("Customer created successfully", response.getBody().getStatusDesc());
    }

}
