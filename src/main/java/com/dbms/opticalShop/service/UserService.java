package com.dbms.opticalShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbms.opticalShop.model.User;
import com.dbms.opticalShop.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void removeUserById(int id) {
		userRepository.deleteById(id);
	}

	public User getUserById(int id) {
		return userRepository.getById(id);
	}
	
	public User getUserByEmail(String email) {
		return userRepository.findUserByEmail(email).get();
	}
	
}
