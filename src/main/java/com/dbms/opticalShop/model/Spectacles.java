package com.dbms.opticalShop.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Spectacles {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "brand_id",referencedColumnName = "brand_id")
	private Brand brand;
	
	private int price;
	private int inStockCount;
	private String imageName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "spectacles")
	private Set<Order> spectacles_orders=new HashSet<>();
	
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
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
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
	public Spectacles() {
		super();
	}
	public Spectacles(int id, String name, Brand brand, int price, int inStockCount, String imageName) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.inStockCount = inStockCount;
		this.imageName = imageName;
	}
	
	
	
	
}
