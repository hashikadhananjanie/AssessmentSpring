package com.kn.orderservice.repository;

import com.kn.orderservice.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByEmail(String email);

    @Query(value = "SELECT nextval('cust_reg_code_seq')", nativeQuery = true)
    int getNextCustRegCode();
}
