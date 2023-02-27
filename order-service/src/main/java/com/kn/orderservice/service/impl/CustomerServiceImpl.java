package com.kn.orderservice.service.impl;

import com.kn.orderservice.domain.Customer;
import com.kn.orderservice.dto.CustomerDto;
import com.kn.orderservice.repository.CustomerRepository;
import com.kn.orderservice.response.GeneralResponse;
import com.kn.orderservice.service.CustomerService;
import com.kn.orderservice.util.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public GeneralResponse createCustomer(CustomerDto customerDto) {

        GeneralResponse response = new GeneralResponse();
        try {
            Optional<Customer> customerOpt = customerRepository.findByEmail(customerDto.getEmail());
            if (customerOpt.isPresent()) {
                response.setStatusCode(StatusCode.CUSTOMER_EXIST.getErrorCode())
                        .setStatusDesc("Customer already exist in the system");
                return response;
            }
            Customer customer = modelMapper.map(customerDto, Customer.class);
            customer.setRegistrationCode(String.valueOf(new StringBuilder().append("KNC").append(
                    customerRepository.getNextCustRegCode())));
            customerRepository.save(customer);
            response.setStatusCode(StatusCode.SUCCESS.getErrorCode())
                    .setStatusDesc("Customer created successfully");
        }
        catch (Exception e) {
            log.error("Error occurred. Customer creation failed");
            response.setStatusCode(StatusCode.UNKNOWN_ERROR.getErrorCode())
                    .setStatusDesc("Customer creation failed");
        }
        return response;
    }

}
