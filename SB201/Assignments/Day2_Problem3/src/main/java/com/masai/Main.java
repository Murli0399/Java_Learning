package com.masai;

import java.util.Scanner;

public class Main {
	static void deleteStudentByCode(Scanner sc) {
		System.out.print("Enter Id : ");
		int id = sc.nextInt();
		EmployeeDAO dao = new EmployeeDAOImpl();
		System.out.println(dao.deleteEmployeeById(id));
	}

	static void updateStudentLevel(Scanner sc) {
		System.out.print("Enter Id : ");
		int id = sc.nextInt();
		System.out.print("Enter Salary : ");
		int salary = sc.nextInt();
		EmployeeDAO dao = new EmployeeDAOImpl();
		System.out.println(dao.updateEmployeeSalary(id, salary));
	}

	static void getStudentByCode(Scanner sc) {
		System.out.print("Enter Id : ");
		int id = sc.nextInt();
		EmployeeDAO dao = new EmployeeDAOImpl();
		Employee emp = dao.getEmployeeById(id);
		System.out.println(emp.toString());
	}

	static void saveStudentDetails(Scanner sc) {
		System.out.print("Enter Id : ");
		int id = sc.nextInt();
		System.out.print("Enter Name : ");
		String name = sc.next();
		System.out.print("Enter Address : ");
		String address = sc.next();
		System.out.print("Enter Salary : ");
		int salary = sc.nextInt();

		Employee emp = new Employee(id, name, address, salary);
		EmployeeDAO dao = new EmployeeDAOImpl();
		System.out.println(dao.registerEmployee(emp));

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int choice = 0;

		do {

			System.out.println("1. Register Employee");
			System.out.println("2. Get Employee By Id");
			System.out.println("3. Update Employee Salary");
			System.out.println("4. Delete Employee by Id");
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
