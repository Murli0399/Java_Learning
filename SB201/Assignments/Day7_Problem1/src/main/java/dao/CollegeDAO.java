package dao;

import model.Student;
import model.Teacher;

public interface CollegeDAO {
	public void addStudent(Student student);

	public Student getStudent(int studentId);

	public void registerTeacher(Teacher teacher, int studentId);

	public Teacher getTeacher(int teacherId);

	public void registerTeacherWithDiffStudents(int teacherId, int studentId);
}
