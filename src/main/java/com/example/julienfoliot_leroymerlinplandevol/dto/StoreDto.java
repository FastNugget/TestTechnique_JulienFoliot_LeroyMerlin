package com.example.julienfoliot_leroymerlinplandevol.dto;

import lombok.Data;

import java.util.List;

@Data
public class StoreDto {

    private Long id;

    private String storeid;
    private int positionx;
    private int positiony;

    private List<ProductDto> products;
}
