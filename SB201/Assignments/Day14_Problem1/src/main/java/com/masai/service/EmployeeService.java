package com.masai.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.masai.model.Employee;

@Service
public class EmployeeService {
	private Map<Integer, Employee> empMap = new HashMap<>();

	public EmployeeService() {
		empMap.put(1, new Employee(1, "Murli", "Khaire", "murli@gmail.com", "Manager"));
		empMap.put(2, new Employee(2, "Rahul", "Patel", "rahul@gmail.com", "Developer"));
		empMap.put(3, new Employee(3, "Mohit", "Viswakarma", "mohit@gmail.com", "Web Developer"));
		empMap.put(4, new Employee(4, "Shalu", "Gour", "shalu@gmail.com", "Finance"));
		empMap.put(5, new Employee(5, "Yagyavi", "Markandey", "yagyavi@gmail.com", "Banking"));
	}

	public List<Employee> getAllEmployees() {
		return new ArrayList<>(empMap.values());
	}

	public Employee getEmployeeById(int id) {
		return empMap.get(id);
	}

	public void addEmployee(Employee employee) {
		empMap.put(employee.getId(), employee);
	}

	public void updateEmployee(Employee employee) {
		empMap.put(employee.getId(), employee);
	}

	public void deleteEmployee(int id) {
		empMap.remove(id);
	}
}
