package com.dbms.opticalShop.dto;

public class BrandDTO {

	private int id;
	
	private String name;
	
	private String costLevel;
	
	private int modelsCount;

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

	public int getModelsCount() {
		return modelsCount;
	}

	public void setModelsCount(int modelsCount) {
		this.modelsCount = modelsCount;
	}
	
	
}
