package com.masai;

public class Student {
	private String name;
	private String id;

	public Student(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public void init() {
		System.out.println("Initializing student: " + name);
	}

	public void destroy() {
		System.out.println("Destroying student: " + name);
	}

	@Override
	public String toString() {
		return "Student{" + "name='" + name + '\'' + ", id='" + id + '\'' + '}';
	}
}
