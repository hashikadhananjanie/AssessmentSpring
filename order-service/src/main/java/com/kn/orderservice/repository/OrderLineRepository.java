package com.kn.orderservice.repository;

import com.kn.orderservice.domain.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {

    @Query("SELECT o FROM OrderLine o WHERE o.product.id = ?1")
    List<OrderLine> findAllByProduct(int orderId);

}
