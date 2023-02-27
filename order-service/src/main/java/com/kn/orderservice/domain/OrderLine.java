package com.kn.orderservice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class OrderLine extends Auditable implements Serializable {

    private static final long serialVersionUID = -3957588038630631285L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id", nullable=false)
    private Product product;
    private int quantity;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="order_id", nullable=false)
    private Order order;
}
