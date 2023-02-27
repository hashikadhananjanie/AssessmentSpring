package com.kn.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto implements Serializable {

    private static final long serialVersionUID = 3735365911935048553L;

    private int customerId;
    private List<OrderLineDto> orderLines;

}
