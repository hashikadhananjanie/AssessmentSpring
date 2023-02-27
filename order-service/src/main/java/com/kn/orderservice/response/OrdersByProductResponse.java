package com.kn.orderservice.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class OrdersByProductResponse extends GeneralResponse implements Serializable {

    private static final long serialVersionUID = -2760341418292184029L;

    private ProductResponse product;
    private List<OrderByProductResponse> orders;

}
