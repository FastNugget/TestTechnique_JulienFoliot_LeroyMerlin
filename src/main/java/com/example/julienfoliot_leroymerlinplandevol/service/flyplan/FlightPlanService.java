package com.example.julienfoliot_leroymerlinplandevol.service.flyplan;

import com.example.julienfoliot_leroymerlinplandevol.dto.*;
import com.example.julienfoliot_leroymerlinplandevol.repository.DroneRepository;
import com.example.julienfoliot_leroymerlinplandevol.repository.OrderRepository;
import com.example.julienfoliot_leroymerlinplandevol.repository.OrderedProductRepository;
import com.example.julienfoliot_leroymerlinplandevol.repository.StoreRepository;
import com.example.julienfoliot_leroymerlinplandevol.service.flyplan.action.FlightActionAbstract;
import com.example.julienfoliot_leroymerlinplandevol.service.flyplan.action.FlightActionDeliver;
import com.example.julienfoliot_leroymerlinplandevol.service.flyplan.action.FlightActionMove;
import com.example.julienfoliot_leroymerlinplandevol.service.flyplan.action.FlightActionPickup;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Configuration
@Service
public class FlightPlanService {

    // -- REPOS
    private OrderRepository orderRepository;
    private OrderedProductRepository orderedProductRepository;
    private DroneRepository droneRepository;
    private StoreRepository storeRepository;

    // -- UTILS
    private ModelMapper modelMapper;
    private Gson gson;


    // -- CONSTRUCTOR --------------------------------------------------------------------------------------------------
    @Autowired
    public FlightPlanService(OrderedProductRepository orderedProductRepository, OrderRepository orderRepository,
                             DroneRepository droneRepository, StoreRepository storeRepository, ModelMapper modelMapper, Gson gson) {

        // -- Injec
        this.orderRepository = orderRepository;
        this.orderedProductRepository = orderedProductRepository;
        this.droneRepository = droneRepository;
        this.storeRepository = storeRepository;

        // -- Inject utils
        this.modelMapper = modelMapper;
        this.gson = gson;

    }


    // -- OUTER CALLBACKS ----------------------------------------------------------------------------------------------

    public String drawFlyPlan() {

        // -- Init
        String jsonToReturn;

        // -- Retrieve order and map to dto
        List<OrderDto> listOrderDto = this.orderRepository.findAllBy().stream()
                .map(orderEntity -> modelMapper.map(orderEntity, OrderDto.class))
                .collect(Collectors.toList());

        List<DroneDto> listDrone = this.droneRepository.findAllBy().stream().map(drone -> this.modelMapper.map(drone, DroneDto.class)).collect(Collectors.toList());
        List<StoreDto> listStore = this.storeRepository.findAllBy().stream().map(store -> this.modelMapper.map(store, StoreDto.class)).collect(Collectors.toList());

        // -- Draw & receive flight plan for each
        List<FlightPlanModel> listFlightPlan = listOrderDto.stream().map(orderDto -> this.drawFlightPlans(orderDto, listStore)).collect(Collectors.toList());

        // -- Assign drones to flightPlans
        this.assignDroneOnFlightPlan(listFlightPlan, listDrone);

        // -- Convert in json
        jsonToReturn = this.gson.toJson(listFlightPlan);

        // -- Serve
        return jsonToReturn;

    }


    // -- INNER CALLBACKS ----------------------------------------------------------------------------------------------

    private FlightPlanModel drawFlightPlans(OrderDto orderDto, List<StoreDto> listStore) {

        // -- Init
        FlightPlanModel flightPlanModel = null;

        // -- Get product in order
        List<OrderedProductDto> listOrderedProduct
                = this.orderedProductRepository.findAllByOrderId(orderDto.getId())
                .stream().map(orderedProduct -> this.modelMapper.map(orderedProduct, OrderedProductDto.class))
                .collect(Collectors.toList());

        CustomerDto customerDto = listOrderedProduct.get(0).getCustomer();
        List<FlightActionAbstract> listFlightAction = new ArrayList<>();

        for (int offset_A = 0; offset_A < listOrderedProduct.size(); offset_A++) {

            // -- Get Product
            OrderedProductDto orderProductUnit = listOrderedProduct.get(offset_A);

            // -- Get store that have a stock on product
            StoreDto storeDtoChoose = listStore.stream()
                    .filter(storeDto -> storeDto.getProducts().stream().map(productDto -> productDto.getProductid()).collect(Collectors.toList()).contains(orderProductUnit.getProductId()))
                    .findFirst().orElse(null);

            // -- Add to package
            listFlightAction.add(new FlightActionMove(storeDtoChoose.getPositionx(), storeDtoChoose.getPositiony()));
            listFlightAction.add(new FlightActionPickup());

        }

        // -- Add move & deliver
        listFlightAction.add(new FlightActionMove(customerDto.getPositionx(), customerDto.getPositiony()));
        listFlightAction.add(new FlightActionDeliver());

        // -- Return
        return flightPlanModel;

    }

    private void assignDroneOnFlightPlan(List<FlightPlanModel> listFlightPlan, List<DroneDto> listDrones) {

        // -- Loop over flightPlanModel
        listFlightPlan.forEach(flightPlanModel -> {

            // -- Init
            AtomicInteger distance = null;
            AtomicReference<DroneDto> choosenDrone = null;

            // -- Work
            listDrones.forEach(droneDto -> {

                flightPlanModel.setDroneDto(droneDto);
                int tmpDistance = flightPlanModel.getTotalDistanceToParcours();

                if ((distance == null || tmpDistance < distance.get()) && tmpDistance < droneDto.getAutonomy()) {

                    choosenDrone.set(droneDto);
                    distance.set(tmpDistance);

                }

            });

        });


    }


    // -- HARICOT ------------------------------------------------------------------------------------------------------

    @Bean
    public ModelMapper modelMapper() {return new ModelMapper();}

    @Bean
    public Gson gson() {return new Gson();}

}
