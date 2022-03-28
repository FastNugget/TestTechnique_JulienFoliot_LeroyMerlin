package com.example.julienfoliot_leroymerlinplandevol.repository;

import com.example.julienfoliot_leroymerlinplandevol.entity.Customer;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CustomerRepository  extends Repository<Customer, Long>{

   List<Customer> findAllBy();

}
