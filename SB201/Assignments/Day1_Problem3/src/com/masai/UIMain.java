package com.masai;

import java.util.Scanner;

public class UIMain {
	
	static void updateLawyerExperience(Scanner sc){
		System.out.print("Enter Id : ");
		int id = sc.nextInt();
		System.out.print("Enter Salary : ");
		int salary = sc.nextInt();
		CourtDAO courtDAO = new CourtDAOImpl();
		System.out.println(courtDAO.updateLawyerExperience(id, salary));
	}
	
	static void deleteLawyerById(Scanner sc) {
		System.out.print("Enter Id : ");
		int id = sc.nextInt();
		CourtDAO courtDAO = new CourtDAOImpl();
		System.out.println(courtDAO.deleteLawyerById(id));
	}
	
	static void saveLawyer(Scanner sc) {

		System.out.print("Enter Name : ");
		String name = sc.next();
		System.out.print("Enter Email : ");
		String email = sc.next();
		System.out.print("Enter Address : ");
		String address = sc.next();
		System.out.print("Enter Salary : ");
		int salary = sc.nextInt();

		Lawyer lawyer = new Lawyer(name, email, address, salary);
		CourtDAO courtDAO = new CourtDAOImpl();

		System.out.println(courtDAO.saveLawyer(lawyer));

	}

	static void findLawyerById(Scanner sc) {
		CourtDAO courtDAO = new CourtDAOImpl();
		System.out.print("Enter Id : ");
		int id = sc.nextInt();
		Lawyer lawyer = courtDAO.findLawyerById(id);
		if(lawyer != null) {
			System.out.println(lawyer.getId() + " " + lawyer.getName() + " " + lawyer.getAddress() + " " + lawyer.getEmail()
			+ " " + lawyer.getExperience());
		}
		else {
			System.out.println("Nothing");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int choice = 0;

		do {

			System.out.println("1. Find Lawyer");
			System.out.println("2. Save Lawyer");
			System.out.println("3. Delete Lawyer");
			System.out.println("4. Update Lawyer Experience");
			System.out.print("Enter Selection : ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				findLawyerById(sc);
				break;
			case 2:
				saveLawyer(sc);
				break;
			case 3:
				deleteLawyerById(sc);
				break;
			case 4:
				updateLawyerExperience(sc);
				break;
				
			case 0:
				System.out.println("Thank you");
				break;
			}

		} while (choice != 0);
	}

}
