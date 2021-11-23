package com.dbms.opticalShop.dto;

public class PastOrdersDTO {
	
	private String spectacleName;
	
	private int quantity;
	
	private String customerName;
	
	private int amount;
	
	private String brandName;

	public String getSpectacleName() {
		return spectacleName;
	}

	public void setSpectacleName(String spectacleName) {
		this.spectacleName = spectacleName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PastOrdersDTO [spectacleName=" + spectacleName + ", quantity=" + quantity + ", CustomerName="
				+ customerName + ", amount=" + amount + "]";
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	

}
