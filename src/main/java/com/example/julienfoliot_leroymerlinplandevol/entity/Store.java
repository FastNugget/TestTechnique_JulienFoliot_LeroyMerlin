package com.example.julienfoliot_leroymerlinplandevol.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String storeid;
    private int positionx;
    private int positiony;

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Product> products;

}
