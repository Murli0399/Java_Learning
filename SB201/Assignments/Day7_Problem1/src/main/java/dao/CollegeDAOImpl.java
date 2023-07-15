package dao;

import javax.persistence.EntityManager;

import exception.StudentException;
import exception.StudentNotFoundException;
import exception.TeacherNotFoundException;
import model.Student;
import model.Teacher;
import util.EMUtils;

public class CollegeDAOImpl implements CollegeDAO {

	public void addStudent(Student student) {
		EntityManager em = EMUtils.getEntityManager();
		Student s = em.find(Student.class, student.getStudentId());
		if (s != null)
			throw new StudentNotFoundException("Student already Present");

		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
		em.close();
	}

	public Student getStudent(int studentId) {
		EntityManager em = EMUtils.getEntityManager();
		Student s = em.find(Student.class, studentId);
		if (s == null)
			throw new StudentNotFoundException("Student Not Present");
		em.close();
		return s;
	}

	public void registerTeacher(Teacher teacher, int studentId) {
		EntityManager em = EMUtils.getEntityManager();
		Student s = em.find(Student.class, studentId);
		if (s == null)
			throw new StudentException("Student Not Present");
		em.getTransaction().begin();
		s.getTeachers().add(teacher);
		em.getTransaction().commit();
		em.close();
	}

	public Teacher getTeacher(int teacherId) {
		EntityManager em = EMUtils.getEntityManager();
		Teacher t = em.find(Teacher.class, teacherId);
		if (t == null)
			throw new TeacherNotFoundException("Teacher Not Present");
		em.close();
		return t;
	}

	public void registerTeacherWithDiffStudents(int teacherId, int studentId) {
		EntityManager em = EMUtils.getEntityManager();
		Teacher t = em.find(Teacher.class, teacherId);
		if (t == null)
			throw new TeacherNotFoundException("Teacher Not Present");
		Student s = em.find(Student.class, studentId);
		if (s == null)
			throw new StudentException("Student Not Present");
		em.getTransaction().begin();
		s.getTeachers().add(t);
		em.getTransaction().commit();
		em.close();
	}

}
