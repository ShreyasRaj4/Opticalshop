package com.dbms.opticalShop.dto;

public class OrderDTO {
	
	private int id;
	private int quantity;
	
	private int customerId;
	
	private int spectacleId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public int getSpectacleId() {
		return spectacleId;
	}

	public void setSpectacleId(int spectacleId) {
		this.spectacleId = spectacleId;
	}

	
	public OrderDTO() {
		super();
	}

	public OrderDTO(int id, int quantity, int customerId, int spectacleId) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.customerId = customerId;
		this.spectacleId = spectacleId;
	}

	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", quantity=" + quantity + ", customerId=" + customerId + ", spectacleId="
				+ spectacleId + "]";
	}
	
	

}
