package usecases;

import java.util.Scanner;

import javax.persistence.EntityManager;

import dao.Address;
import dao.Employee;
import util.EMUtils;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee emp = new Employee();
		System.out.print("Enter your Name : ");
		String name = sc.next();
		emp.setName(name);
		System.out.print("Enter your Gender : ");
		String gender = sc.next();
		emp.setGender(gender);
		System.out.print("Enter your Salary : ");
		int salary = sc.nextInt();
		emp.setSalary(salary);
		Address homeAddress = new Address();

		System.out.print("Enter your Home City : ");
		String hcity = sc.next();
		homeAddress.setCity(hcity);
		System.out.print("Enter your Home State : ");
		String hstate = sc.next();
		homeAddress.setState(hstate);
		System.out.print("Enter your Home Type : ");
		String htype = sc.next();
		homeAddress.setType(htype);
		System.out.print("Enter your Home Pincode : ");
		String hpin = sc.next();
		homeAddress.setPincode(hpin);

		Address officeAddress = new Address();
		System.out.print("Enter your Office City : ");
		String ocity = sc.next();
		officeAddress.setCity(ocity);
		System.out.print("Enter your Office State : ");
		String ostate = sc.next();
		officeAddress.setState(ostate);
		System.out.print("Enter your Office Type : ");
		String otype = sc.next();
		officeAddress.setType(otype);
		System.out.print("Enter your Office Pincode : ");
		String opin = sc.next();
		officeAddress.setPincode(opin);

		emp.getEmpAddress().add(homeAddress);
		emp.getEmpAddress().add(officeAddress);

		EntityManager em = EMUtils.getEntityManager();
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		em.close();

	}
}
