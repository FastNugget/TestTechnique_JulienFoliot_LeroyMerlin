package com.example.julienfoliot_leroymerlinplandevol.service.flyplan.action;

public class FlightActionDeliver extends FlightActionAbstract{

    @Override
    public FlightActionType getFlyActionType() {
        return FlightActionType.DELIVER;
    }

}
