package com.masai.problem02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student(1, "Murli", 530));
		list.add(new Student(2, "Aman", 259));
		list.add(new Student(3, "Rahul", 505));
		list.add(new Student(4, "Krishna", 547));
		list.add(new Student(5, "Sachin", 445));

		list.stream().max(Comparator.comparing(Student::getMarks)).ifPresent(System.out::print);
	}
}
