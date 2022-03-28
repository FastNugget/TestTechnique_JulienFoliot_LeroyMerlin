package com.example.julienfoliot_leroymerlinplandevol.repository;

import com.example.julienfoliot_leroymerlinplandevol.entity.Drone;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

 @Transactional
 public interface DroneRepository extends Repository<Drone, Long> {

    List<Drone> findAllBy();


}
