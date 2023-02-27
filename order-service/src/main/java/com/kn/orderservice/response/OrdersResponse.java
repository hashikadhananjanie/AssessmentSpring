package com.kn.orderservice.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class OrdersResponse extends GeneralResponse implements Serializable {

    private static final long serialVersionUID = -8868452668072142895L;

    private List<OrderResponse> orders;
}
