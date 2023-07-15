package com.masai.problem3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<Student> list = new ArrayList<>();
		list.add(new Student(1, "Murli", 598, "Muakdhe121", new Address("MP", "Khandwa", 450001)));
		list.add(new Student(2, "Rahul", 505, "sdefde121", new Address("MP", "Indore", 689575)));
		list.add(new Student(3, "Aman", 468, "jfkjdlkje121", new Address("MP", "Bhopal", 858585)));
		list.add(new Student(4, "Shalu", 435, "oiredfd34", new Address("DD", "Delhi", 450001)));
		list.add(new Student(5, "Mohit", 568, "sdwheui338", new Address("MH", "Mumbai", 748574)));

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("studentdata.ser"));
		oos.writeObject(list);
		oos.close();
		System.out.println("Data is Added");
	}
}
