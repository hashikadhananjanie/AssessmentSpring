package com.kn.orderservice.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "orders")
public class Order extends Auditable implements Serializable {

    private static final long serialVersionUID = -160839530475657060L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy="order", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<OrderLine> orderLines = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    private LocalDate submissionDate;
}
