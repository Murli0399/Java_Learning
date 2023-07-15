package com.masai.problem01;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "Murli", "Khandwa", 50000));
		empList.add(new Employee(2, "Mohit", "Hyderabad", 40000));
		empList.add(new Employee(3, "Shalu", "indore", 30000));
		empList.add(new Employee(4, "Yagyavi", "Bhopal", 2000));
		empList.add(new Employee(5, "Sawan", "Khargone", 3000));
		empList.add(new Employee(6, "Yashpal", "Mumbai", 5000));
		empList.add(new Employee(7, "Heer", "Delhi", 10000));
		empList.add(new Employee(8, "Mahi", "Kolkata", 15000));
		empList.add(new Employee(9, "Ram", "chainnai", 13500));
		empList.add(new Employee(10, "Gopal", "Ahmdabad", 60500));

		empList.forEach(i -> {
			if (i.getSalary() < 5000) {
				i.setSalary(i.getSalary() + 1000);
			}
		});
		System.out.println(empList);

	}
}
