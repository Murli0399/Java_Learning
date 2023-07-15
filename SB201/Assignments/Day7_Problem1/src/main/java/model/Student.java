package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String studentName;
	private String course;
	private String location;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Teacher> teachers = new ArrayList<>();

	public Student() {
		super();
	}

	public Student(String studentName, String course, String location) {
		this.studentName = studentName;
		this.course = course;
		this.location = location;
	}

	public Student(int studentId, String studentName, String course, String location) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.course = course;
		this.location = location;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

}
