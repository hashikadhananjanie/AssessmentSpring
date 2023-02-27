package com.kn.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto implements Serializable {

    private static final long serialVersionUID = -4925663255610370565L;

    private String name;
    private String skuCode;
    private double unitPrice;
}
