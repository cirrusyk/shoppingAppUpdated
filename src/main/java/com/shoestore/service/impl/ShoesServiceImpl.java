package com.shoestore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoestore.domain.Shoes;
import com.shoestore.repository.ShoesRepository;
import com.shoestore.service.ShoesService;

@Service
public class ShoesServiceImpl implements ShoesService {
	
	
	@Autowired
	private ShoesRepository shoesRepository;
	



	
	public List<Shoes> findAll() {
		return (List<Shoes>) shoesRepository.findAll();
	}





	@Override
	public Shoes findOne(Long id) {
		
		return shoesRepository.findById(id).orElse(null);
	}



	
	
}
