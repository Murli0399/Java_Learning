package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Product;
import com.masai.sevice.ProductService;

@RestController
@CrossOrigin("*")
public class ProductController {
	@Autowired
	private ProductService ps;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getallProduct() {

		List<Product> pl = ps.getAllProduct();

		return new ResponseEntity<>(pl, HttpStatus.OK);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id) {

		Product pl = ps.getProductById(id);

		return new ResponseEntity<>(pl, HttpStatus.OK);
	}

	@PostMapping("/products")
	public ResponseEntity<Product> addStudentHandler(@RequestBody Product product) {

		Product ans = ps.addProduct(product);

		return new ResponseEntity<>(ans, HttpStatus.OK);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Product> getProdctById(@PathVariable Integer id, @RequestBody Product p) {

		Product pl = ps.updateProductById(id, p);

		return new ResponseEntity<>(pl, HttpStatus.OK);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> deleteProductById(@PathVariable Integer id) {

		Product pl = ps.deleteProductById(id);

		return new ResponseEntity<>(pl, HttpStatus.OK);
	}

}
