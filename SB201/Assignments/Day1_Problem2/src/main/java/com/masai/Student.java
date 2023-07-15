package com.masai;

public class Student {
	private int rollNo;
	private String studentName;
	private String address;
	private int marks;

	public Student(int rollNo, String studentName, String address, int marks) {
		this.rollNo = rollNo;
		this.studentName = studentName;
		this.address = address;
		this.marks = marks;
	}

	public Student(String studentName, String address, int marks) {
		this.studentName = studentName;
		this.address = address;
		this.marks = marks;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Roll No : " + rollNo + ", Name : " + studentName + ", Address : " + address + ", Marks : " + marks;
	}

}
