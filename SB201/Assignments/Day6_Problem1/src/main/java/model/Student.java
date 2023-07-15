package model;

import javax.persistence.*;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentRoll;
	private String studentName;
	private String mobileNumber;
	private String email;

	@ManyToOne
	@JoinColumn(name = "college_id")
	private College college;

	public Student() {
	}

	public Student(String studentName, String mobileNumber, String email, College college) {
		this.studentName = studentName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.college = college;
	}

	public Student(int studentRoll, String studentName, String mobileNumber, String email, College college) {
		this.studentRoll = studentRoll;
		this.studentName = studentName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.college = college;
	}

	public int getStudentRoll() {
		return studentRoll;
	}

	public void setStudentRoll(int studentRoll) {
		this.studentRoll = studentRoll;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Student [studentRoll=" + studentRoll + ", studentName=" + studentName + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", college=" + college + "]";
	}

	

}
