package com.example.julienfoliot_leroymerlinplandevol.dto;

import lombok.Data;

@Data
public class ProductDto {

    // -- Thanks lombok we love u
    private Long id;
    private String productid;
    private String productname;
    private int quantity;

}
