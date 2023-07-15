package com.masai.problem2;

import java.io.*;
import java.time.LocalDate;

class Employee {
	int employeeId;

	Employee(int employeeId) {
		this.employeeId = employeeId;
	}
}

class PermanentEmployee extends Employee implements Serializable {
	transient int epfoNumber;
	static String epfoOrganization;
	LocalDate joiningDate;
	float balance;

	static {
		epfoOrganization = "EPFO, Govt. of India";
	}

	PermanentEmployee(int employeeId, int epfoNumber, float balance) {
		super(employeeId);
		this.epfoNumber = epfoNumber;
		this.balance = balance;
	}
}

public class FileRecapDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		PermanentEmployee pmOne = new PermanentEmployee(101, 1001, 10001.0f);
		ObjectOutput oo = new ObjectOutputStream(new FileOutputStream("Employee.ser"));
		oo.writeObject(pmOne);
		oo.close();

		System.out.println();

		ObjectInput oi = new ObjectInputStream(new FileInputStream("Employee.ser"));
		PermanentEmployee pmTwo = (PermanentEmployee) oi.readObject();
		oi.close();
	}
}
//

//(iii) How many variable will be serialized for object of class PermanentEmployee?
//Ans -> 4

//(viii) At the time of deserialization, some problem is going to occur, can you suggest improvement to avoid the same?
//Ans -> We can catch the exception and handle it appropriately. For example,
//we can display an error message to the user or take some other action depending on the nature of the problem.



