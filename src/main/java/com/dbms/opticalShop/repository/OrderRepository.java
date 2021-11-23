package com.dbms.opticalShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbms.opticalShop.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
