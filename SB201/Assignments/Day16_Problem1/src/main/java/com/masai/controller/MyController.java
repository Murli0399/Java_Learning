package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Flat;
import com.masai.service.FlatService;

@RestController
@CrossOrigin("*")
public class MyController {

	@Autowired
	private FlatService fs;

	@PostMapping("/flats")
	public ResponseEntity<Flat> addFlatHandler(@RequestBody Flat flat) {

		Flat f = fs.addFlat(flat);
		return new ResponseEntity<>(f, HttpStatus.OK);
	}

	@GetMapping("/flats")
	public ResponseEntity<List<Flat>> getAllFlatHandler() {

		List<Flat> list = fs.getAllFlat();

		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/flats/{price}")
	public ResponseEntity<List<Flat>> getFlatByPriceLess(@PathVariable Double price) {

		List<Flat> list = fs.getFlatByPriceLessThan(price);

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
