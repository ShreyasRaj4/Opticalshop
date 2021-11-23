package com.dbms.opticalShop.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dbms.opticalShop.service.BrandService;
import com.dbms.opticalShop.service.SpectaclesService;
import com.dbms.opticalShop.service.UserService;

@Controller
public class HomeController {

	@Autowired
	BrandService brandService;
	
	@Autowired
	SpectaclesService spectaclesService;
	
	@Autowired
	UserService userService;
	
	@GetMapping({"/","/home"})
	public String home() {
		return "redirect:shop";
	}
	
	@GetMapping("/shop")
	public String shop(Model model) {
		model.addAttribute("cartCount",0);
		model.addAttribute("brands",brandService.getAllBrands());
		model.addAttribute("spectacles",spectaclesService.getAllSpectacles());
		return "shop";
	}
	
	@GetMapping("/shop/brand/{id}")
	public String shopByCategory(@PathVariable("id")int id,Model model) {
		model.addAttribute("cartCount",0);
		model.addAttribute("brands",brandService.getAllBrands());
		model.addAttribute("spectacles",spectaclesService.getAllSpectaclesByBrandId(id));
		return "shop";
	}
	
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(@PathVariable("id") int id,Model model) {
		model.addAttribute("cartCount",0);
		model.addAttribute("spectacle",spectaclesService.getSpectaclesById(id).get());
		return "viewProduct";
	}
}
