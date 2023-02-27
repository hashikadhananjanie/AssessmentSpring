package com.kn.orderservice.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class GeneralResponse implements Serializable {

    private static final long serialVersionUID = 2737167208533642304L;

    private int statusCode;
    private String statusDesc;
}
