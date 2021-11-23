package com.dbms.opticalShop.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int quantity;
	
//    @ManyToOne
//    @JoinColumn(name="user_id", nullable=false)
//	private User user;
//	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="orderedCustomer_id",referencedColumnName = "id")
	private Customer orderedCustomer;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="spectacles_id",referencedColumnName = "id")
	private Spectacles spectacles;

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

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public Customer getOrderedCustomer() {
		return orderedCustomer;
	}

	public void setOrderedCustomer(Customer orderedCustomer) {
		this.orderedCustomer = orderedCustomer;
	}

	public Spectacles getSpectacles() {
		return spectacles;
	}

	public void setSpectacles(Spectacles spectacles) {
		this.spectacles = spectacles;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", quantity=" + quantity + ", orderedCustomer=" + orderedCustomer
				+ ", spectacles=" + spectacles + "]";
	}
	
}
