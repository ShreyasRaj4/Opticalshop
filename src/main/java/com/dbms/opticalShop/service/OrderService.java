package com.dbms.opticalShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbms.opticalShop.model.Order;
import com.dbms.opticalShop.model.User;
import com.dbms.opticalShop.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	public void addOrder(Order order) {
		orderRepository.save(order);
	}
	
	public List<Order> pastOrders() {
		return orderRepository.findAll();
	}
}
