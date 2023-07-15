package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Flat;
import com.masai.repository.FlatRepository;

@Service
public class FlatServiceImpl implements FlatService {

	@Autowired
	private FlatRepository fr;

	@Override
	public Flat addFlat(Flat flat) {
		Flat f = fr.save(flat);
		return f;
	}

	@Override
	public List<Flat> getAllFlat() {

		return fr.findAll();
	}

	@Override
	public List<Flat> getFlatByPriceLessThan(Double price) {
		List<Flat> f = fr.findFlatByPriceLessThan(price);
		return f;
	}

}
