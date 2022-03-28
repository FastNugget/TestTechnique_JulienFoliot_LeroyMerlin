package com.example.julienfoliot_leroymerlinplandevol.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "orderedproduct")
@Getter
@Setter
public class OrderedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private Order order;


    private String productId;
    private long quantity;

}
