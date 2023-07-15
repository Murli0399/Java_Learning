package usecases;

import dao.CollegeDAO;
import dao.CollegeDAOImpl;
import model.Student;
import model.Teacher;

public class Main {

	static void addStudent() {

		Student student = new Student();
		student.setStudentName("Shyam");
		student.setCourse("Web");
		student.setLocation("Indore");

		Teacher t1 = new Teacher();
		t1.setSubject("Java");
		t1.setTeacherName("Rahul");
		student.getTeachers().add(t1);

		Teacher t2 = new Teacher();
		t2.setSubject("Mysql");
		t2.setTeacherName("Viraj");
		student.getTeachers().add(t2);

		Teacher t3 = new Teacher();
		t3.setSubject("Html");
		t3.setTeacherName("Ajinkya");
		student.getTeachers().add(t3);

		CollegeDAO dao = new CollegeDAOImpl();
		dao.addStudent(student);

	}

	static void getStudent() {
		CollegeDAO dao = new CollegeDAOImpl();
		Student s = dao.getStudent(2);
		System.out.println(s.getStudentId() + " " + s.getStudentName() + " " + s.getCourse() + " " + s.getLocation()
				+ " " + s.getTeachers().get(0).getTeacherId() + " " + s.getTeachers().get(0).getTeacherName());
	}

	static void registerTeacher() {
		CollegeDAO dao = new CollegeDAOImpl();
		Teacher t = new Teacher();
		t.setSubject("Python");
		t.setTeacherName("Shalu");

		dao.registerTeacher(t, 1);
	}

	static void registerTeacherWithDiffStudents() {
		CollegeDAO dao = new CollegeDAOImpl();
		dao.registerTeacherWithDiffStudents(4, 2);
	}

	public static void main(String[] args) {
		getStudent();
	}
}
