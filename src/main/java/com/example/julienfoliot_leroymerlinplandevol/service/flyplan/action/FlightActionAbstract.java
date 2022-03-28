package com.example.julienfoliot_leroymerlinplandevol.service.flyplan.action;

public abstract class FlightActionAbstract {

    // -- Var
    protected String actionType;

    // -- CONS
    public enum FlightActionType {MOVE, PICKUP, DELIVER}


    // -- CONSTRUCTOR --------------------------------------------------------------------------------------------------

    public FlightActionAbstract(){

        // -- Set
        this.actionType = this.getFlyActionType().name();

    }


    // -- CALLBACKS ----------------------------------------------------------------------------------------------------

    public abstract FlightActionType getFlyActionType();


}
