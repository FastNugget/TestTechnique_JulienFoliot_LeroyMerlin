package com.example.julienfoliot_leroymerlinplandevol.dto;

import lombok.Data;

@Data
public class OrderedProductDto {

    private Long id;

    private OrderDto order;

    private CustomerDto customer;

    private String productId;
    private long quantity;

}