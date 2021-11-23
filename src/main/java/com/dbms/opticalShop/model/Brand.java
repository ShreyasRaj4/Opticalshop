package com.dbms.opticalShop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="brand_id")
	private int id;
	
	private String name;
	
	private String costLevel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCostLevel() {
		return costLevel;
	}

	public void setCostLevel(String costLevel) {
		this.costLevel = costLevel;
	}

	public Brand() {
		super();
	}
	
	
}
