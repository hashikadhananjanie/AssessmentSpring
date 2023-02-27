package com.kn.orderservice.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class OrderByProductResponse implements Serializable {

    private static final long serialVersionUID = 7739406965860135259L;

    private int orderId;
    private int orderLineId;
    private int quantity;
    private LocalDate orderDate;
    private CustomerResponse customer;
}
