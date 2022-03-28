package com.example.julienfoliot_leroymerlinplandevol.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String orderid;

    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private Customer customer;

}
