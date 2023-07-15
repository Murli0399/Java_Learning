package com.masai.problem3;

import java.io.Serializable;

public class Student implements Serializable {
	private int roll;
	private String name;
	private int marks;
	transient String Password;
	private Address address;

	public Student(int roll, String name, int marks, String password, Address address) {
		super();
		this.roll = roll;
		this.name = name;
		this.marks = marks;
		Password = password;
		this.address = address;
	}

	public int getRoll() {
		return roll;
	}

	public String getName() {
		return name;
	}

	public int getMarks() {
		return marks;
	}

	public String getPassword() {
		return Password;
	}

	public Address getAddress() {
		return address;
	}

}
