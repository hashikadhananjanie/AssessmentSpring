package com.kn.orderservice.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class CustomerResponse implements Serializable {

    private static final long serialVersionUID = 4009150595558305531L;

    @JsonProperty("customerId")
    private int id;
    private String fullName;
    private String email;
    private String telephone;
    private String registrationCode;
}
