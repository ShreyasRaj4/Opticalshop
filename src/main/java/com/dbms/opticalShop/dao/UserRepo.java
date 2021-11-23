package com.dbms.opticalShop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {

	@Autowired
	JdbcTemplate template;

	public boolean isEmailPresent(String email) {
		return false;
	}
	
}
