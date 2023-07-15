package com.masai;

import javax.persistence.*;

@Entity
public class Student {
	@Id
	private int studentCode;
	private String email;
	private String address;
	private String course;
	private int level;

	public int getStudentCode() {
		return studentCode;
	}

	public Student(int studentCode, String email, String address, String course, int level) {
		super();
		this.studentCode = studentCode;
		this.email = email;
		this.address = address;
		this.course = course;
		this.level = level;
	}

	public Student() {
	}

	public void setStudentCode(int studentCode) {
		this.studentCode = studentCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Student Code : " + studentCode + ", Email : " + email + ", Address : " + address + ", Course : "
				+ course + ", Level : " + level;
	}
}
