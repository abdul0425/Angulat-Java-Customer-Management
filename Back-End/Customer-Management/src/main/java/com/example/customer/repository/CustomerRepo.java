package com.example.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.customer.model.CustomerModel;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerModel, Integer> {

}
