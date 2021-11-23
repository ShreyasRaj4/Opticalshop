package com.dbms.opticalShop.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dbms.opticalShop.dao.OrderRepo;
import com.dbms.opticalShop.dao.SpectacleRepoJDBC;
import com.dbms.opticalShop.dto.CustomerIdDTO;
import com.dbms.opticalShop.dto.OrderDTO;
import com.dbms.opticalShop.dto.PastOrdersDTO;
import com.dbms.opticalShop.model.Customer;
import com.dbms.opticalShop.model.Order;
import com.dbms.opticalShop.model.Spectacles;
// import com.dbms.opticalShop.model.User;
import com.dbms.opticalShop.service.BrandService;
import com.dbms.opticalShop.service.CustomerService;
import com.dbms.opticalShop.service.OrderService;
import com.dbms.opticalShop.service.SpectaclesService;
import com.dbms.opticalShop.service.UserService;

@Controller
public class SaleController {
	
	@Autowired
	BrandService brandService;
	
	@Autowired
	SpectaclesService spectaclesService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	SpectacleRepoJDBC spectacleRepoJDBC;
	
	@Autowired
	OrderRepo orderRepo;

	@GetMapping("/shop/spectacles/sell/{id}")
	public String sellSpectacles(@PathVariable("id")int id,Model model) {
		
		Spectacles spectacles=spectaclesService.getSpectaclesById(id).get();
		model.addAttribute("spectacleName",spectacles.getName());
		model.addAttribute("quantityLeft",spectacles.getInStockCount());
		model.addAttribute("spectacleCost",spectacles.getPrice());
		
		List<Customer> customers=customerService.getAllCustomers();
		
		model.addAttribute("customers",customers);
		
		OrderDTO orderDTO= new OrderDTO();
		orderDTO.setSpectacleId(id);
		
		model.addAttribute("orderDTO",orderDTO);
		return "sellSpectacles";
	}
	
	@PostMapping("/shop/order/add")
	public String placeOrder(@ModelAttribute("orderDTO") OrderDTO orderDTO) {
		
		int spectacleId=orderDTO.getSpectacleId();
		int customerId=orderDTO.getCustomerId();
		int remainingPieces=spectaclesService.getSpectaclesById(spectacleId).get().getInStockCount();

		if(orderDTO.getQuantity()>remainingPieces) {
			System.out.println("ekkuva adigindu");
			return "selectNumberOfPiecesNA";
		}
		
		int piecesSold=orderDTO.getQuantity();
		spectacleRepoJDBC.decreaseSpectacleCount(remainingPieces-piecesSold, spectacleId);
		
		
		// User user = userService.getUserById(22);
		
		Order order = new Order();
		order.setOrderedCustomer(customerService.getCustomerById(customerId).get());
		order.setQuantity(piecesSold);
		order.setSpectacles(spectaclesService.getSpectaclesById(spectacleId).get());

		System.out.println(order.toString());
		
		orderService.addOrder(order);
		
		return "redirect:/shop";
	}
	
	@GetMapping("/pastOrders")
	public String pastOrders(Model model) {
		
		List<Order> pastOrders = orderService.pastOrders();
		
		List<PastOrdersDTO> pastOrdersDTOs=new ArrayList<PastOrdersDTO>();
		
		for (int i = 0; i < pastOrders.size(); i++) {
			
			Order thisOrder = pastOrders.get(i);
			
			PastOrdersDTO pastOrdersDTO = new PastOrdersDTO();
			
			int customerId=thisOrder.getOrderedCustomer().getId();
			int spectacleId=thisOrder.getSpectacles().getId();
			
			
			pastOrdersDTO.setCustomerName(customerService.getCustomerById(customerId).get().getFirst_name());
			pastOrdersDTO.setQuantity(thisOrder.getQuantity());
			
			Spectacles spectacle = spectaclesService.getSpectaclesById(spectacleId).get();
			String spectacleName = spectacle.getName();
			pastOrdersDTO.setSpectacleName(spectacleName);
			pastOrdersDTO.setBrandName(spectacle.getBrand().getName());
			
			int amount=(int)(thisOrder.getQuantity()*spectacle.getPrice());
			pastOrdersDTO.setAmount(amount);
			
			
			//System.out.println(pastOrdersDTO.toString());
			
			pastOrdersDTOs.add(pastOrdersDTO);
		}
		Collections.reverse(pastOrdersDTOs);
		model.addAttribute("pastOrdersDTOs",pastOrdersDTOs);
		List<Customer> customers=customerService.getAllCustomers();
		model.addAttribute("customers",customers);
		
		CustomerIdDTO customerIdDTO = new CustomerIdDTO();
		
		model.addAttribute("customerIdDTO", customerIdDTO);
		
		return "pastOrders";
	}
	
	@PostMapping("/shop/filter/customerId")
	public String filterByCustomerId(@ModelAttribute("customerIdDTO") CustomerIdDTO customerIdDTO,Model model) {
		
		int customerId=customerIdDTO.getId();
		System.out.println("Post Mapped called for Customer Name");
		System.out.println(customerService.getCustomerById(customerId).get().getFirst_name());
		
		List<OrderDTO> pastOrders=orderRepo.pastOrdersByCustomerId(customerId);
		
		List<PastOrdersDTO> pastOrdersDTOs=new ArrayList<PastOrdersDTO>();
		
		for (int i = 0; i < pastOrders.size(); i++) {
			
			OrderDTO thisOrder = pastOrders.get(i);
			PastOrdersDTO pastOrdersDTO = new PastOrdersDTO();

			int spectacleId=thisOrder.getSpectacleId();
			
			
			pastOrdersDTO.setCustomerName(customerService.getCustomerById(customerId).get().getFirst_name());
			pastOrdersDTO.setQuantity(thisOrder.getQuantity());
			
			Spectacles spectacle = spectaclesService.getSpectaclesById(spectacleId).get();
			String spectacleName = spectacle.getName();
			pastOrdersDTO.setSpectacleName(spectacleName);
			pastOrdersDTO.setBrandName(spectacle.getBrand().getName());
			
			int amount=(int)(thisOrder.getQuantity()*spectacle.getPrice());
			pastOrdersDTO.setAmount(amount);
			
			//System.out.println(pastOrdersDTO.toString());
			
			pastOrdersDTOs.add(pastOrdersDTO);
		}
		Collections.reverse(pastOrdersDTOs);
		model.addAttribute("pastOrdersDTOs",pastOrdersDTOs);
		
		List<Customer> customers=customerService.getAllCustomers();
		model.addAttribute("customers",customers);
		
		// CustomerIdDTO customerIdDTO = new CustomerIdDTO();
		model.addAttribute("customerIdDTO", customerIdDTO);
		
		return "pastOrders";
	}
}
