package com.kn.orderservice.controller;

import com.kn.orderservice.dto.ProductDto;
import com.kn.orderservice.response.GeneralResponse;
import com.kn.orderservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.status;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/product", produces = { APPLICATION_JSON_VALUE })
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<GeneralResponse> createProduct(@RequestBody ProductDto productDto) {
        return status(HttpStatus.OK).body(productService.createProduct(productDto));
    }
}
