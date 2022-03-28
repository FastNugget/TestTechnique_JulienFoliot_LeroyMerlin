package com.example.julienfoliot_leroymerlinplandevol.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productid;
    private String productname;
    private int quantity;

}
