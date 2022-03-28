package com.example.julienfoliot_leroymerlinplandevol.repository;

import com.example.julienfoliot_leroymerlinplandevol.entity.Order;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OrderRepository  extends Repository<Order, Long> {

    List<Order> findAllBy();

}
