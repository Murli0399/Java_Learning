package com.masai.service;

import java.util.List;

import com.masai.model.Flat;

public interface FlatService {

	public Flat addFlat(Flat flat);

	public List<Flat> getAllFlat();
	
	public List<Flat> getFlatByPriceLessThan(Double price);
	
}
