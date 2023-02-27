package com.kn.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDto {

    private static final long serialVersionUID = -157912186248812946L;

    private String fullName;
    private String email;
    private String telephone;

}
