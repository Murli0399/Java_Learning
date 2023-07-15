package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/student/{r}")
	public Student getStudent(@PathVariable("r") Integer r) {
		return new Student(r, "Murli", 780);
	}

}
