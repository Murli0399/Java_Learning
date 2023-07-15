package com.masai.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Employee;

import jakarta.annotation.PostConstruct;

@RestController
@CrossOrigin("*")
public class MyController {

	private Map<Integer, Employee> empMap = new HashMap<>();

	@PostConstruct
	public void init() {
		empMap.put(1, new Employee(1,"Murli","2023-04-28",))
	}

}
