package com.kn.orderservice.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class OrderResponse implements Serializable {

    private static final long serialVersionUID = 7739406965860135259L;

    @JsonProperty("orderId")
    private int id;
    private CustomerResponse customer;
    @JsonProperty("orderDate")
    private LocalDate submissionDate;
    private List<OrderLineResponse> orderLines;
}
