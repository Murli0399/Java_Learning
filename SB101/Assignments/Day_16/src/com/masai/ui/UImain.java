package com.masai.ui;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.DepartmentDAO;
import com.masai.dao.DepartmentDAOImpl;
import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;
import com.masai.dto.DepartmentDTO;
import com.masai.dto.DepartmentDTOImpl;
import com.masai.dto.EmployeeDTO;
import com.masai.dto.EmployeeDTOImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrong;

public class UImain {

	static void addEmployee(Scanner sc) {
		System.out.print("Enter Your Name : ");
		String name = sc.next();

		System.out.print("Enter Address : ");
		String address = sc.next();

		System.out.print("Enter Mobile No. : ");
		String mobile = sc.next();

		System.out.print("Enter Deprtment Id : ");
		int deptid = sc.nextInt();

		EmployeeDTO empDto = new EmployeeDTOImpl(name, address, mobile, deptid);
		EmployeeDAO empDao = new EmployeeDAOImpl();

		try {
			empDao.addEmployee(empDto);
			System.out.println("Employee added successfully");
		} catch (SomethingWentWrong e) {
		}
	}

	static void addDepartment(Scanner sc) {
		System.out.print("Enter Department Name : ");
		String name = sc.next();

		System.out.print("Enter Location : ");
		String location = sc.next();

		DepartmentDTO departDto = new DepartmentDTOImpl(name, location);
		DepartmentDAO dao = new DepartmentDAOImpl();

		try {
			dao.addDepartment(departDto);
			System.out.println("Department added successfully");
		} catch (SomethingWentWrong e) {
		}
	}

	static void deleteDepartment(Scanner sc) {
		System.out.print("Enter Department Id : ");
		int id = sc.nextInt();

		DepartmentDAO dao = new DepartmentDAOImpl();

		try {
			dao.deleteDepartment(id);
			System.out.println("Department delete successfully");
		} catch (SomethingWentWrong ex) {
			System.out.println(ex.getMessage());
		}

	}

	static void viewEmployeeAccount() {
		EmployeeDAO dao = new EmployeeDAOImpl();

		try {
			List<EmployeeDTO> list = dao.viewEmployeeAccount();
			list.forEach(System.out::println);

		} catch (SomethingWentWrong | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	static void viewDepartment() {
		DepartmentDAO dao = new DepartmentDAOImpl();

		try {
			List<DepartmentDTO> list = dao.viewDepartment();
			list.forEach(System.out::println);

		} catch (SomethingWentWrong | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int choice = 0;

		do {

			System.out.println("1. Add Employee");
			System.out.println("2. Add Department");
			System.out.println("3. View Employee");
			System.out.println("4. Delete Department");
			System.out.println("5. View Department");

			System.out.println("0. Exit");

			System.out.print("Enter Your Selection : ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				addEmployee(sc);
				break;
			case 2:
				addDepartment(sc);
				break;
			case 3:
				viewEmployeeAccount();
				break;
			case 4:
				deleteDepartment(sc);
				break;
			case 5:
				viewDepartment();
				break;

			case 0:
				System.out.println("Thank you for using our application");
				break;

			}

		} while (choice != 0);

		sc.close();
	}

}