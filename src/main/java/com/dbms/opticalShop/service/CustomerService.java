package com.dbms.opticalShop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbms.opticalShop.model.Customer;
import com.dbms.opticalShop.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository  customerRepository;
	
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}

	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public Optional<Customer> getCustomerById(int id) {
		return customerRepository.findById(id);
	}
}
