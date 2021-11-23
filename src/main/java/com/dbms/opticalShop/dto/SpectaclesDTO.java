package com.dbms.opticalShop.dto;

public class SpectaclesDTO {
	

	private int id;
	private String name;
	private int brandId;
	
	private int price;
	private int inStockCount;
	private String imageName;
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
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getInStockCount() {
		return inStockCount;
	}
	public void setInStockCount(int inStockCount) {
		this.inStockCount = inStockCount;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public SpectaclesDTO() {
		super();
	}
	public SpectaclesDTO(int id, String name, int brandId, int price, int inStockCount, String imageName) {
		super();
		this.id = id;
		this.name = name;
		this.brandId = brandId;
		this.price = price;
		this.inStockCount = inStockCount;
		this.imageName = imageName;
	}
	
	
}
