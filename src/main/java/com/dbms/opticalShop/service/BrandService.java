package com.dbms.opticalShop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbms.opticalShop.model.Brand;
import com.dbms.opticalShop.repository.BrandRepository;

@Service
public class BrandService {

	@Autowired
	BrandRepository brandRepository;
	
	public void addBrand(Brand brand) {
		brandRepository.save(brand);
	}
	
	public List<Brand> getAllBrands(){
		return brandRepository.findAll();
	}
	
	public void removeBrandById(int id) {
		brandRepository.deleteById(id);
	}
	
	public Optional<Brand> getBrandById(int id) {
		return brandRepository.findById(id);
	}
}
