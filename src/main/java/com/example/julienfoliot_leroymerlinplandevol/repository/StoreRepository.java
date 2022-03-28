package com.example.julienfoliot_leroymerlinplandevol.repository;

import com.example.julienfoliot_leroymerlinplandevol.entity.Store;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface StoreRepository extends Repository<Store, Long> {

    List<Store> findAllBy();

}