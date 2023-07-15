package com.masai;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	private List<String> cities;

	@Bean
	public List<String> cities() {

		List<String> cities = Arrays.asList("Khandwa", "Indore", "Bhopal", "Delhi", "Mumbai");

		return cities;
	}

	@Bean
	public List<Student> students() {
		List<Student> students = Arrays.asList(new Student("Alice", "A123"), new Student("Bob", "B456"),
				new Student("Charlie", "C789"), new Student("David", "D012"), new Student("Eve", "E345"));
		return students;
	}
}
