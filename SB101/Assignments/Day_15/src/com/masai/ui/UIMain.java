package com.masai.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import com.masai.dao.MobileDAO;
import com.masai.dao.MobileDAOImpl;
import com.masai.dto.Mobile;
import com.masai.dto.MobileImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrong;

public class UIMain {

	static void addMobile(Scanner sc) {
		System.out.print("Enter Model Number : ");
		String mon = sc.next();

		System.out.print("Enter Company Name : ");
		String com = sc.next();

		System.out.print("Enter Mobile Price : ");
		int price = sc.nextInt();

		System.out.print("Enter Manufactiring Date : ");
		LocalDate mfg = LocalDate.parse(sc.next());

		Mobile mob = new MobileImpl(mon, com, price, mfg);
		MobileDAO dao = new MobileDAOImpl();

		try {
			dao.addMobile(mob);
			System.out.println("Mobile added successfully");
		} catch (SomethingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void updateMobile(Scanner sc) {
		System.out.print("Enter Model Number : ");
		String mon = sc.next();

		System.out.print("Enter Company Name : ");
		String com = sc.next();

		System.out.print("Enter Mobile Price : ");
		int price = sc.nextInt();

		System.out.print("Enter Manufactiring Date : ");
		LocalDate mfg = LocalDate.parse(sc.next());

		Mobile mob = new MobileImpl(mon, com, price, mfg);
		MobileDAO dao = new MobileDAOImpl();

		try {
			dao.updateMobile(mob);
			System.out.println("Mobile updated successfully");
		} catch (SomethingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void deleteMobile(Scanner sc) {
		System.out.print("Enter Model Number : ");
		String mon = sc.next();
		MobileDAO dao = new MobileDAOImpl();
		try {
			dao.deleteMobile(mon);
			System.out.println("Mobile updated successfully");
		} catch (SomethingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void viewMobile() {
		MobileDAO dao = new MobileDAOImpl();
		try {
			List<Mobile> empList = dao.viewMobile();
			Consumer<Mobile> con = m -> System.out.println("Mobile Id " + m.getId() + " Company " + m.getCompany()
					+ " Model Number " + m.getModel_no() + " Manufaturing Date " + m.getMfgdate());
			empList.forEach(con);
		} catch (SomethingWentWrong | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	static void searchByPriceRange(Scanner sc) {
		System.out.print("Enter start Price : ");
		int startP = sc.nextInt();
		System.out.print("Enter end Price : ");
		int endP = sc.nextInt();

		MobileDAO empDAO = new MobileDAOImpl();
		try {
			List<Mobile> empList = empDAO.searchByPriceRange(startP, endP);
			Consumer<Mobile> con = m -> System.out.println("Mobile Id " + m.getId() + " Company " + m.getCompany()
					+ " Model Number " + m.getModel_no() + " Manufaturing Date " + m.getMfgdate());
			empList.forEach(con);
		} catch (SomethingWentWrong | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	static void searchByModel(Scanner sc) {
		System.out.print("Enter Model Number : ");
		String model = sc.next();

		MobileDAO empDAO = new MobileDAOImpl();
		try {
			List<Mobile> empList = empDAO.searchByModel(model);
			Consumer<Mobile> con = m -> System.out.println("Mobile Id " + m.getId() + " Company " + m.getCompany()
					+ " Model Number " + m.getModel_no() + " Manufaturing Date " + m.getMfgdate());
			empList.forEach(con);
		} catch (SomethingWentWrong | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int choice = 0;

		do {

			System.out.println("1. Add Mobile");
			System.out.println("2. Update Mobile");
			System.out.println("3. Delete Mobile");
			System.out.println("4. Display All Mobile");
			System.out.println("5. Search Mobile by Model Number");
			System.out.println("6. Search Mobile by Price Range");

			System.out.println("0. Exit");

			System.out.print("Enter Your Selection : ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				addMobile(sc);
				break;
			case 2:
				updateMobile(sc);
				break;
			case 3:
				deleteMobile(sc);
				break;
			case 4:
				viewMobile();
				break;
			case 5:
				searchByModel(sc);
				break;
			case 6:
				searchByPriceRange(sc);
				break;
			case 0:
				System.out.println("Thank you for using our application");
				break;

			}

		} while (choice != 0);

	}

}
