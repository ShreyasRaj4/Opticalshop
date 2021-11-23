package com.dbms.opticalShop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dbms.opticalShop.dto.OrderDTO;

@Repository
public class OrderRepo {

	@Autowired
	JdbcTemplate template;
	
	public List<OrderDTO> pastOrdersByCustomerId(int id){
		
		String query="select id,quantity,ordered_customer_id,spectacles_id from orders where ordered_customer_id=?";
		List<OrderDTO> items = template.query(query,new Object[]{id},(rs, rowNum) ->
        new OrderDTO(
        		rs.getInt("id"),
        		rs.getInt("quantity"),
        		rs.getInt("ordered_customer_id"),
        		rs.getInt("spectacles_id")
        )
				);
		return items;
	}
}
