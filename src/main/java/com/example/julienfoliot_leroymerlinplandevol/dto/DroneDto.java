package com.example.julienfoliot_leroymerlinplandevol.dto;

import lombok.Data;

@Data
public class DroneDto {

    // -- Thanks lombok we love u
    private String droneid;
    private int autonomy;
    private int positionx;
    private int positiony;

}
