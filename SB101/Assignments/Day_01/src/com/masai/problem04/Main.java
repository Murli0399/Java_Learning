package com.masai.problem04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {

	public static Map<String, Student> sortMapUsingStudentName(Map<String, Student> originalMap) {

		List<Entry<String, Student>> list = new ArrayList<>(originalMap.entrySet());

		Comparator<Entry<String, Student>> comp = (o1, o2) -> o1.getValue().getName()
				.compareTo(o2.getValue().getName());

		list.sort(comp);

		Map<String, Student> map = new LinkedHashMap<>();

		list.forEach(e -> map.put(e.getKey(), e.getValue()));

		return map;
	}

	public static void main(String[] args) {
		Map<String, Student> studentMap = new HashMap<>();
		studentMap.put("India", new Student(101, "Amit", "amit@gmail.com", 85));
		studentMap.put("USA", new Student(102, "Murli", "murli@gmail.com", 90));
		studentMap.put("Canada", new Student(103, "Rahul", "rahul@gmail.com", 75));
		studentMap.put("Australia", new Student(104, "David", "david@gmail.com", 80));
		studentMap.put("France", new Student(105, "Pooja", "pooja@gmail.com", 92));
		studentMap.put("Shrilanka", new Student(106, "Radhe", "radhe@gmail.com", 70));
		studentMap.put("China", new Student(107, "Nic", "nic@gmail.com", 88));
		studentMap.put("Japan", new Student(108, "Mahi", "mahi@gmail.com", 82));
		studentMap.put("Russia", new Student(109, "Irina", "irina@gmail.com", 95));
		studentMap.put("Mexico", new Student(110, "Jhon", "jhon@gmail.com", 78));

		Map<String, Student> result = Main.sortMapUsingStudentName(studentMap);

		for (Entry<String, Student> e : result.entrySet()) {
			System.out.println(e.getKey() + " => " + e.getValue());
		}

	}
}
