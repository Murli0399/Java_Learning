package com.masai;

import java.sql.SQLException;

public class StudentService {
	private StudentDao studentDao;

	public StudentService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void addStudent(Student student) throws SQLException {
		studentDao.addStudent(student);
	}
}
