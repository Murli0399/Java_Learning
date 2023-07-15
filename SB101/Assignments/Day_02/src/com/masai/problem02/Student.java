package com.masai.problem02;

public class Student {

	@Override
	public String toString() {
		return "Student Name = " + name;
	}

	private String name;

	Student(String name) {

		this.name = name;
	}

	public String getName() {
		return name;
	}

}