package com.masai;

import java.util.Scanner;

public class Main {
	static void deleteStudentByCode(Scanner sc) {
		System.out.print("Enter Code : ");
		int code = sc.nextInt();
		MasaiDAO dao = new MasaiDAOImpl();
		System.out.println(dao.deleteStudentById(code));
	}

	static void updateStudentLevel(Scanner sc) {
		System.out.print("Enter Code : ");
		int code = sc.nextInt();
		System.out.print("Enter Level : ");
		int level = sc.nextInt();
		MasaiDAO dao = new MasaiDAOImpl();
		System.out.println(dao.updateStudentLevel(code, level));
	}

	static void getStudentByCode(Scanner sc) {
		System.out.print("Enter Code : ");
		int code = sc.nextInt();
		MasaiDAO dao = new MasaiDAOImpl();
		Student student = dao.findStudentById(code);
		System.out.println(student.toString());
	}

	static void saveStudentDetails(Scanner sc) {
		System.out.print("Enter Code : ");
		int code = sc.nextInt();
		System.out.print("Enter Email : ");
		String email = sc.next();
		System.out.print("Enter Address : ");
		String address = sc.next();
		System.out.print("Enter Course : ");
		String course = sc.next();
		System.out.print("Enter Level : ");
		int level = sc.nextInt();

		Student student = new Student(code, email, address, course, level);
		MasaiDAO dao = new MasaiDAOImpl();
		System.out.println(dao.saveStudent(student));

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int choice = 0;

		do {

			System.out.println("1. Save Student");
			System.out.println("2. Get Student By Code");
			System.out.println("3. Update Student Level");
			System.out.println("4. Delete Student By Code");
			System.out.print("Enter Selection : ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				saveStudentDetails(sc);
				break;
			case 2:
				getStudentByCode(sc);
				break;
			case 3:
				updateStudentLevel(sc);
				break;
			case 4:
				deleteStudentByCode(sc);
				break;
			case 0:
				System.out.println("Thank you");
				break;
			}

		} while (choice != 0);
	}
}
