package com.masai;

public interface MasaiDAO {
	Student findStudentById(int id);

	String saveStudent(Student student);

	String deleteStudentById(int id);

	String updateStudentLevel(int id, int level);
}
