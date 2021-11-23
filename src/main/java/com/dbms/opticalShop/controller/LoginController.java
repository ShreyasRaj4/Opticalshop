package com.dbms.opticalShop.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dbms.opticalShop.dao.UserRepo;
import com.dbms.opticalShop.model.Department;
import com.dbms.opticalShop.model.Role;
import com.dbms.opticalShop.model.User;
import com.dbms.opticalShop.repository.DepartmentRepository;
import com.dbms.opticalShop.repository.RoleRepository;
import com.dbms.opticalShop.repository.UserRepository;
import com.dbms.opticalShop.service.UserService;


@Controller
public class LoginController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired 
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/login")
	public String login() {
		//GlobalData.cart.clear();
		return "login";
	}
	
	@GetMapping("/register")
	public String registerGet() {
		return "register";
	}
	
	@PostMapping("/register")
	public String registerPost(@ModelAttribute("user")User user, HttpServletRequest httpServletRequest) 
			throws ServletException {
	
		
		String password = user.getPassword();
		user.setPassword(bCryptPasswordEncoder.encode(password));
		List<Role> roles = new ArrayList<>();
		roles.add(roleRepository.findById(2).get());
		user.setRoles(roles);
		Set<Department> departments= new HashSet<>();
		departments.add(departmentRepository.findById(2).get());
		userRepository.save(user);
		
		httpServletRequest.login(user.getEmail(), password);
		return "redirect:/";
	}
}
