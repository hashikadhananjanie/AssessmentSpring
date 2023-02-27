package com.kn.orderservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product extends Auditable implements Serializable {

    private static final long serialVersionUID = -8218573181956110012L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String skuCode;
    @Column(nullable = false)
    private double unitPrice;
    @OneToMany(mappedBy="product", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<OrderLine> orderLines;

}
