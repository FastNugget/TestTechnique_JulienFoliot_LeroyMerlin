package com.example.julienfoliot_leroymerlinplandevol.service.flyplan;

import com.example.julienfoliot_leroymerlinplandevol.dto.CustomerDto;
import com.example.julienfoliot_leroymerlinplandevol.dto.DroneDto;
import com.example.julienfoliot_leroymerlinplandevol.service.flyplan.action.FlightActionAbstract;
import com.example.julienfoliot_leroymerlinplandevol.service.flyplan.action.FlightActionMove;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class FlightPlanModel {

    // -- VARS
    final private List<FlightActionAbstract> listFlightAction = new ArrayList<>();
    private DroneDto droneDto;
    private CustomerDto customerDto;


    // -- UTILS --------------------------------------------------------------------------------------------------------

    public int getTotalDistanceToParcours(){

        // -- Init
        int totalDistanceToParcours = 0;

        // -- Get
        List<FlightActionMove> listMove
            = this.listFlightAction.stream()
                .filter(unit-> unit instanceof FlightActionMove)
                    .map(unit-> FlightActionMove.class.cast(unit))
                            .collect(Collectors.toList());

        // -- Start from the end because start is by drone
        Collections.reverse(listMove);

        // -- Init
        int total = 0;
            int lastx = this.droneDto != null ? this.droneDto.getPositionx():0;
            int lasty = this.droneDto != null ? this.droneDto.getPositiony():0;

        // -- Compute
        for(int offset = 0; offset< listMove.size(); offset++){

            // -- Get
            FlightActionMove fam = listMove.get(offset);

            // -- Case begin
            if(offset == 0){

                // -- Init
                lastx = fam.getTox();
                lasty = fam.getToy();


            }else{

                // -- Add
                total+= this.determineDelta(lastx, fam.getTox()) + this.determineDelta(lasty, fam.getToy());


            }

        }

        // -- Commit
        return total;

    }

    private int determineDelta(int xa, int xb){

        // -- Init
        int deltaToCommit = 0;

        // -- Work
        if((Integer.signum(xa) == 1) && (Integer.signum(xb) == 1)){

            deltaToCommit = (xa>xb)
                    ? xa - xb
                    : xa<xb
                    ? xb - xa
                    :0;

        }else if((Integer.signum(xa) == -1) && (Integer.signum(xb) == -1)){

            deltaToCommit = ( ~xa> ~xb)
                    ?  ~xa - ~xb
                    :  ~xa < ~xb
                    ?  ~xb - ~xa
                    :0;

        }else if(((Integer.signum(xa) == -1) && (Integer.signum(xa) == 1))
                || ((Integer.signum(xa) == 1) && (Integer.signum(xa) == -1))){


            int xaVerified = (Integer.signum(xa) == -1)?~xa:xa;
            int xbVerified = (Integer.signum(xb) == -1)?~xb:xb;

            deltaToCommit =  xaVerified + xbVerified;

        }

        // -- Commit
        return deltaToCommit;

    }


}
