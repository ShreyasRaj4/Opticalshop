package com.dbms.opticalShop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbms.opticalShop.model.Spectacles;
import com.dbms.opticalShop.repository.SpectaclesRepository;


@Service
public class SpectaclesService {

	@Autowired
	SpectaclesRepository spectaclesRepository;
	
	public List<Spectacles> getAllSpectacles(){
		return spectaclesRepository.findAll();
	}
	
	public void addSpectacles(Spectacles spectacles) {
		spectaclesRepository.save(spectacles);
	}
	
	public void removeSpectaclesById(int id) {
		spectaclesRepository.deleteById(id);
	}
	

	public Optional<Spectacles> getSpectaclesById(int id) {
		return spectaclesRepository.findById(id);
	}
	
	public List<Spectacles> getAllSpectaclesByBrandId(int id){
		return spectaclesRepository.findSpectaclesByBrandId(id);
	}

}
