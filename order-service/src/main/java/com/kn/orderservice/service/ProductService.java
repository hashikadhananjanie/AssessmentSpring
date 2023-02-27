package com.kn.orderservice.service;

import com.kn.orderservice.dto.ProductDto;
import com.kn.orderservice.response.GeneralResponse;

public interface ProductService {
    GeneralResponse createProduct(ProductDto productDto);
}
