package com.masai;

import java.util.Scanner;

public class UIMain {

	static void deleteEmployeeById(Scanner sc) {
		System.out.print("Enter Id : ");
		int id = sc.nextInt();
		EmployeeDAO dao = new EmployeeDAOImpl();
		try {
			if (dao.deleteEmployee(id)) {
				System.out.println("Employee deleted Successful");
			}
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void giveBonusEmployee(Scanner sc) {
		System.out.print("Enter Id : ");
		int id = sc.nextInt();
		System.out.print("Enter Bonus : ");
		int salary = sc.nextInt();
		EmployeeDAO dao = new EmployeeDAOImpl();
		try {
			System.out.println(dao.giveBonusToEmployee(id, salary));
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void getAddressById(Scanner sc) {

		System.out.print("Enter Id : ");
		int id = sc.nextInt();

		EmployeeDAO dao = new EmployeeDAOImpl();
		try {
			System.out.println(dao.getAddressOfEmployee(id));
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void registerEmployee(Scanner sc) {
		System.out.print("Enter Name : ");
		String name = sc.next();
		System.out.print("Enter Address : ");
		String address = sc.next();
		System.out.print("Enter Salary : ");
		int salary = sc.nextInt();

		Employee obj = new Employee(name, address, salary);
		EmployeeDAO dao = new EmployeeDAOImpl();
		dao.save(obj);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int choice = 0;

		do {

			System.out.println("1. Register Employee");
			System.out.println("2. Get Address of Employee By Id");
			System.out.println("3. Give Bonus");
			System.out.println("4. Delete Employee By Id");
			System.out.print("Enter Selection : ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				registerEmployee(sc);
				break;
			case 2:
				getAddressById(sc);
				break;
			case 3:
				giveBonusEmployee(sc);
				break;
			case 4:
				deleteEmployeeById(sc);
				break;

			case 0:
				System.out.println("Thank you");
				break;
			}

		} while (choice != 0);
	}

}
