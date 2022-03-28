package com.example.julienfoliot_leroymerlinplandevol.service.flyplan.action;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FlightActionPickup extends FlightActionAbstract{

    // -- VARS
    private String store = null;
    private String productToPickup = null;

    // -- IMPL ---------------------------------------------------------------------------------------------------------
    @Override
    public FlightActionType getFlyActionType() {
        return FlightActionType.PICKUP;
    }
}
