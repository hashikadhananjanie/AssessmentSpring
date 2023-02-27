package com.kn.orderservice.repository;

import com.kn.orderservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findBySkuCode(String sku);
}
