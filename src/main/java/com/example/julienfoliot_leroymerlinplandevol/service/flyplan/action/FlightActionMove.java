package com.example.julienfoliot_leroymerlinplandevol.service.flyplan.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FlightActionMove extends FlightActionAbstract{

    // -- VARS
    private int moveDestinationX;
    private int moveDestinationY;

    // -- IMPL ---------------------------------------------------------------------------------------------------------

    @Override
    public FlightActionType getFlyActionType() {
        return FlightActionType.MOVE;
    }
}
