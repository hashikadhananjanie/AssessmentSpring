package com.kn.orderservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer extends Auditable implements Serializable {

    private static final long serialVersionUID = 1110251888181398740L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String registrationCode;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    private String telephone;

    @OneToMany(mappedBy="customer", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Order> orders;
}
