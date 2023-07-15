package com.masai.problem04;

import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Set<Student> set = new HashSet<>();

		set.add(new Student(1, "Murli", 530));
		set.add(new Student(2, "Aman", 259));
		set.add(new Student(3, "Rahul", 149));
		set.add(new Student(4, "Krishna", 547));
		set.add(new Student(4, "Krishna", 547));
		set.add(new Student(5, "Sachin", 445));

		set.stream().filter(i -> i.getMarks() < 500).forEach(System.out::println);

	}
}
