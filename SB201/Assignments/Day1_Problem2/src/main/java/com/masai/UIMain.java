package com.masai;

import java.util.List;
import java.util.Scanner;

public class UIMain {

	static void deleteStudentByRollNo(Scanner sc) {
		System.out.print("Enter Id : ");
		int id = sc.nextInt();
		StudentDAO dao = new StudentDAOImpl();
		try {
			System.out.println(dao.deleteStudentByRollNo(id));
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void graceStudentMarks(Scanner sc) {
		System.out.print("Enter Id : ");
		int id = sc.nextInt();
		System.out.print("Enter Salary : ");
		int salary = sc.nextInt();
		StudentDAO dao = new StudentDAOImpl();
		try {
			System.out.println(dao.graceStudentMarks(id, salary));
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void getAllStudent() {
		StudentDAO dao = new StudentDAOImpl();

		List<Student> emp = dao.getAllStudent();
		emp.forEach(System.out::println);

	}

	static void getStudentByRollNo(Scanner sc) {

		System.out.print("Enter Roll No : ");
		int id = sc.nextInt();

		StudentDAO dao = new StudentDAOImpl();
		try {
			Student emp = dao.getStudentByRollNo(id);
			System.out.println("Roll No : " + emp.getRollNo() + ", Name : " + emp.getStudentName() + ", Address : "
					+ emp.getAddress() + ", Marks : " + emp.getMarks());
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void getStudentsByName(Scanner sc) {

		System.out.print("Enter Name : ");
		String id = sc.next();

		StudentDAO dao = new StudentDAOImpl();
		try {
			Student emp = dao.getStudentsByName(id);
			System.out.println("Roll No : " + emp.getRollNo() + ", Name : " + emp.getStudentName() + ", Address : "
					+ emp.getAddress() + ", Marks : " + emp.getMarks());
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void saveStudentDetails(Scanner sc) {
		System.out.print("Enter Name : ");
		String name = sc.next();
		System.out.print("Enter Address : ");
		String address = sc.next();
		System.out.print("Enter Marks : ");
		int marks = sc.nextInt();

		Student obj = new Student(name, address, marks);
		StudentDAO dao = new StudentDAOImpl();
		System.out.println(dao.saveStudentDetails(obj));

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int choice = 0;

		do {

			System.out.println("1. Register Student");
			System.out.println("2. Get All Student");
			System.out.println("3. Get Student By Roll No");
			System.out.println("4. Get Student By Name");
			System.out.println("5. Grace Student Marks");
			System.out.println("6. Delete Student By Roll No");
			System.out.print("Enter Selection : ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				saveStudentDetails(sc);
				break;
			case 2:
				getAllStudent();
				break;
			case 3:
				getStudentByRollNo(sc);
				break;
			case 4:
				getStudentsByName(sc);
				break;
			case 5:
				graceStudentMarks(sc);
				break;
			case 6:
				deleteStudentByRollNo(sc);
				break;
			case 0:
				System.out.println("Thank you");
				break;
			}

		} while (choice != 0);
	}

}
