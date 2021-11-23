package com.dbms.opticalShop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SpectacleRepoJDBC {

	@Autowired
	JdbcTemplate template;
	
	public void decreaseSpectacleCount(int rem,int id) {
		String query = "update spectacles set in_stock_count = ? where id = ?";
		template.update(query,rem,id);
		return;
	}

}
