package com.masai.problem04;

public class Student {
	private int roll;
	private String name;
	private String email;
	private int marks;

	Student(int roll, String name, String email, int marks) {
		this.roll = roll;
		this.name = name;
		this.email = email;
		this.marks = marks;
	}

	public int getRoll() {
		return roll;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getMarks() {
		return marks;
	}

	@Override
	public String toString() {
		return "roll=" + roll + ", name=" + name + ", email=" + email + ", marks=" + marks + "\n";
	}

}
