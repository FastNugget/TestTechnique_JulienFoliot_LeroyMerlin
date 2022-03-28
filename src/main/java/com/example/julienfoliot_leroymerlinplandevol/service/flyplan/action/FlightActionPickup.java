package com.example.julienfoliot_leroymerlinplandevol.service.flyplan.action;

public class FlightActionPickup extends FlightActionAbstract{

    @Override
    public FlightActionType getFlyActionType() {
        return FlightActionType.PICKUP;
    }
}
