package com.kn.orderservice.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class OrderLineResponse implements Serializable {

    private static final long serialVersionUID = -6430892743261673378L;

    @JsonProperty("OrderLineId")
    private int id;
    private ProductResponse product;
    private int quantity;

}
