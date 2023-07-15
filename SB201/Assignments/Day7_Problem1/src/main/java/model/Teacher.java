package model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacherId;
	private String teacherName;
	private String subject;

	@ManyToMany(mappedBy = "teachers", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Student> students;

	public Teacher() {
	}

	public Teacher(String teacherName, String subject) {
		this.teacherName = teacherName;
		this.subject = subject;
	}

	public Teacher(int teacherId, String teacherName, String subject) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.subject = subject;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
