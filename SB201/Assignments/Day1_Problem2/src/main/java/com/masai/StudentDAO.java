package com.masai;

import java.util.List;

public interface StudentDAO {

	public Student getStudentByRollNo(int rollNo)throws StudentException;

	public List<Student> getAllStudent();

	public String saveStudentDetails(Student student);

	public String deleteStudentByRollNo(int rollNo)throws StudentException;

	public String graceStudentMarks(int rollNo, int marks)throws StudentException;

	public Student getStudentsByName(String name)throws StudentException;
}
