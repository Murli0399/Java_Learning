package com.masai.problem02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<String> city = new ArrayList<>();
		city.add("Khandwa");
		city.add("Hyderabad");
		city.add("Indore");
		city.add("Bhopal");
		city.add("Khargone");
		city.add("Mumbai");
		city.add("Delhi");
		city.add("Kolkata");
		city.add("Chainnai");
		city.add("Ahmdabad");

		Collections.sort(city, (city1 , city2) -> city2.compareTo(city1));
		
		System.out.println(city);

	}

}
