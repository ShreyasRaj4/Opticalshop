package com.dbms.opticalShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbms.opticalShop.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{
	
}
