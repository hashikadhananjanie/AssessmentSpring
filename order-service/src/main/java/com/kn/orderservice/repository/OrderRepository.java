package com.kn.orderservice.repository;

import com.kn.orderservice.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllBySubmissionDate(LocalDate date);

    @Query("SELECT o FROM Order o WHERE o.customer.id = ?1")
    List<Order> findAllByCustomer(int customerId);
}
