package com.dbms.opticalShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dbms.opticalShop.model.Customer;
import com.dbms.opticalShop.service.BrandService;
import com.dbms.opticalShop.service.CustomerService;
import com.dbms.opticalShop.service.SpectaclesService;


@Controller
public class CustomerController {
	
	@Autowired
	BrandService brandService;
	
	@Autowired
	SpectaclesService spectaclesService;
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/shop/customers/add")
	public String customerAdd(Model model) {
		model.addAttribute("customer",new Customer());
		return "customerAdd";
	}
	
	@PostMapping("/shop/customers/add")
	public String postBrandAdd(@ModelAttribute("customer") Customer customer) {
		if(customer.getPhone().length()!=10)
		{
			return "customerAdd";
		}
		customerService.addCustomer(customer);
		return "redirect:/shop";
	}
	
}
