package com.example.julienfoliot_leroymerlinplandevol.dto;

import lombok.Data;

@Data
public class DroneDto {

    private Long id;
    private String droneid;
    private int autonomy;
    private int positionx;
    private int positiony;

}
