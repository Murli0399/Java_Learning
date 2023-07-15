package com.masai;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		StudentService studentService = context.getBean(StudentService.class);

		Student student = new Student();
		student.setName("Murli Khaire");
		student.setEmail("murlikhaire@");

		try {
			studentService.addStudent(student);
			System.out.println("Student record inserted successfully.");
		} catch (SQLException e) {
			System.out.println("Error inserting student record: " + e.getMessage());
		}
	}
}
