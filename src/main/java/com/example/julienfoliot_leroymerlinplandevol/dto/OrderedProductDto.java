package com.example.julienfoliot_leroymerlinplandevol.dto;

import lombok.Data;

@Data
public class OrderedProductDto {

    // -- Thanks lombok we love u
    private Long id;
    private OrderDto order;
    private String productId;
    private long quantity;

}