package com.kn.orderservice.service.impl;

import com.kn.orderservice.domain.Product;
import com.kn.orderservice.dto.ProductDto;
import com.kn.orderservice.repository.ProductRepository;
import com.kn.orderservice.response.GeneralResponse;
import com.kn.orderservice.service.ProductService;
import com.kn.orderservice.util.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public GeneralResponse createProduct(ProductDto productDto) {

        GeneralResponse response = new GeneralResponse();
        try {
            Optional<Product> productOpt = productRepository.findBySkuCode(productDto.getSkuCode());
            if (productOpt.isPresent()) {
                response.setStatusCode(StatusCode.PRODUCT_EXIST.getErrorCode())
                        .setStatusDesc("Product already exist in the system");
                return response;
            }
            Product product = modelMapper.map(productDto, Product.class);
            productRepository.save(product);
            response.setStatusCode(StatusCode.SUCCESS.getErrorCode())
                    .setStatusDesc("Product created successfully");
        }
        catch (Exception e) {
            log.error("Error occurred. Product creation failed");
            response.setStatusCode(StatusCode.UNKNOWN_ERROR.getErrorCode())
                    .setStatusDesc("Product creation failed");
        }
        return response;
    }

}
