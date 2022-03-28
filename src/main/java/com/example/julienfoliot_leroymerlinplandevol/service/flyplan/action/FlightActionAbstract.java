package com.example.julienfoliot_leroymerlinplandevol.service.flyplan.action;

public abstract class FlightActionAbstract {

    // -- CONS
    public enum FlightActionType {MOVE, PICKUP, DELIVER}


    // -- CALLBACKS ----------------------------------------------------------------------------------------------------

    public abstract FlightActionType getFlyActionType();


}
