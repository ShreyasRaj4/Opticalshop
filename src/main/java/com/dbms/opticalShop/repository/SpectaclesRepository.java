package com.dbms.opticalShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbms.opticalShop.model.Spectacles;

public interface SpectaclesRepository extends JpaRepository<Spectacles, Integer>{

	
	List<Spectacles> findSpectaclesByBrandId(int id);

	void deleteByBrandId(int id);

}
