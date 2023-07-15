package com.masai.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Flat;

public interface FlatRepository extends JpaRepository<Flat, Integer> {

	public List<Flat> findFlatByPriceLessThan(Double price);
//
//	public List<Flat> findFlatByPriceLessThanEqualTo(Double price);
//
//	public List<Flat> findFlatByPriceGreaterThan(Double price);
//
//	public List<Flat> findFlatByPriceBetween(Double s_price, Double e_price);

}
