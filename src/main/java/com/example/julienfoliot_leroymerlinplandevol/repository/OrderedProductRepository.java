package com.example.julienfoliot_leroymerlinplandevol.repository;

import com.example.julienfoliot_leroymerlinplandevol.entity.OrderedProduct;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OrderedProductRepository  extends Repository<OrderedProduct, Long> {

    List<OrderedProduct> findAllBy();

    List<OrderedProduct> findAllByOrderId(Long orderId);

}