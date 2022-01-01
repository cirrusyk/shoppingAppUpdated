package com.shoestore.service;

import java.util.List;

import com.shoestore.domain.Shoes;

public interface ShoesService {
	List<Shoes> findAll();
	
	Shoes findOne(Long id);
}