package com.example.julienfoliot_leroymerlinplandevol.dto;

import lombok.Data;

@Data
public class OrderDto {

    // -- Thanks lombok we love u
    private Long id;
    private String orderid;
    private CustomerDto customer;

}
