package com.dbms.opticalShop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbms.opticalShop.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findUserByEmail(String email);
	
	public User findByEmail(String email);
}
