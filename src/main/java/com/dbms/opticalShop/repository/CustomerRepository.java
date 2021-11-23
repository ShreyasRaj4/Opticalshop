package com.dbms.opticalShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbms.opticalShop.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
