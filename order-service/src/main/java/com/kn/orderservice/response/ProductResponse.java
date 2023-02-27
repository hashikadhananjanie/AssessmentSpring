package com.kn.orderservice.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ProductResponse implements Serializable {

    private static final long serialVersionUID = 6169833903806355852L;

    @JsonProperty("productId")
    private int id;
    private String name;
    private String skuCode;
    private double unitPrice;
}
