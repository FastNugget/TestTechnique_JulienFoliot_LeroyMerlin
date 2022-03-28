package com.example.julienfoliot_leroymerlinplandevol.service.flyplan.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FlightActionMove extends FlightActionAbstract{

    private int tox;
    private int toy;

    @Override
    public FlightActionType getFlyActionType() {
        return FlightActionType.MOVE;
    }
}
