package com.masai.problem04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student(101, "Amit", 585));
		studentList.add(new Student(102, "Murli", 390));
		studentList.add(new Student(103, "Rahul", 275));
		studentList.add(new Student(104, "David", 580));
		studentList.add(new Student(105, "Pooja", 492));
		studentList.add(new Student(106, "Radhe", 270));
		studentList.add(new Student(107, "Nic", 588));
		studentList.add(new Student(108, "Mahi", 482));
		studentList.add(new Student(109, "Irina", 595));
		studentList.add(new Student(110, "Jhon", 378));

		Intr inter = list -> {

			List<Student> result = new ArrayList<>();

			list.forEach(ch -> {
				if (ch.getMarks() < 500) {
					result.add(ch);
				}
			});

			return result;

		};

//		Comparator<Student> comp = (s1, s2) -> {
//			if (s1.getMarks() < s2.getMarks())
//				return 1;
//			return -1;
//		};
//
//		studentList.stream().filter(i -> i.getMarks() < 500).sorted(comp).forEach(System.out::println);

		inter.findStudent(studentList).forEach(System.out::println);

	}
}
