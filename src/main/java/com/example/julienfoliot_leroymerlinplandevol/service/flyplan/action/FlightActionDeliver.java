package com.example.julienfoliot_leroymerlinplandevol.service.flyplan.action;


import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor

public class FlightActionDeliver extends FlightActionAbstract{

    // -- VARS
    @NonNull private String customerName;
    private final List<String> productToDeliver = new ArrayList<>();

    // -- IMPL ---------------------------------------------------------------------------------------------------------

    @Override
    public FlightActionType getFlyActionType() {
        return FlightActionType.DELIVER;
    }

    public void addProductInList(String productId){
        this.productToDeliver.add(productId);

    }

}
