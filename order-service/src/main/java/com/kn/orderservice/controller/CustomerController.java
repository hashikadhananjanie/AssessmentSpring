package com.kn.orderservice.controller;

import com.kn.orderservice.dto.CustomerDto;
import com.kn.orderservice.response.GeneralResponse;
import com.kn.orderservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.status;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/customer", produces = { APPLICATION_JSON_VALUE })
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<GeneralResponse> createCustomer(@RequestBody CustomerDto customerDto) {
        return status(HttpStatus.OK).body(customerService.createCustomer(customerDto));
    }

}
