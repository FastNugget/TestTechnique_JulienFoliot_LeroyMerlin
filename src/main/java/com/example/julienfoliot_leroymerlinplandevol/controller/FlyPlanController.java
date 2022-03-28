package com.example.julienfoliot_leroymerlinplandevol.controller;

import com.example.julienfoliot_leroymerlinplandevol.service.flyplan.FlightPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class FlyPlanController {

    // -- SERVICE
    private FlightPlanService flightPlanService;


    // -- CONSTRUCTOR --------------------------------------------------------------------------------------------------
    @Autowired
    public FlyPlanController(FlightPlanService flightPlanService){

        // -- Injec
        this.flightPlanService = flightPlanService;

    }


    // -- CONTROLLERS --------------------------------------------------------------------------------------------------
    @GetMapping(value = "/flyplan", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getFlyPlan() {

        // -- Draw & commit
        return ResponseEntity.ok().body(this.flightPlanService.drawFlyPlan());

    }


}
