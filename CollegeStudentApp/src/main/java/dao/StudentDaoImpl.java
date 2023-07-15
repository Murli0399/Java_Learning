package dao;

import java.util.List;

import entities.College;
import entities.Student;
import exceptions.CollegeException;
import exceptions.StudentException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utilities.EMUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public Student registerStudent(Student student) throws StudentException {
		if (student == null)
			throw new StudentException("Student Obj is null");
		EntityManager em = EMUtil.provideEntityManager();
		Student obj = em.find(Student.class, student.getStudentRoll());
		if (obj != null)
			throw new StudentException("Student is already present");
		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
		em.close();
		return student;
	}

	@Override
	public Student getStudentFromStudentId(int studentId) throws StudentException {
		EntityManager em = EMUtil.provideEntityManager();
		Student obj = em.find(Student.class, studentId);
		if (obj == null)
			throw new StudentException("Student is not present");
		return obj;
	}

	@Override
	public List<Student> getAllActiveStudents() throws StudentException {
		EntityManager em = EMUtil.provideEntityManager();

		String q = "SELECT s FROM Student s WHERE s.status = :n";
		Query obj = em.createQuery(q);
		obj.setParameter("n", true);
		List<Student> list = obj.getResultList();
		if (list.isEmpty())
			throw new StudentException("Students is empty");
		return list;
	}

	@Override
	public College getCollegeFromStudentId(int studentId) throws CollegeException, StudentException {
		EntityManager em = EMUtil.provideEntityManager();
		Student obj = em.find(Student.class, studentId);
		if (obj == null)
			throw new StudentException("Student is not present");
		College clg = obj.getCollege();
		if (clg == null)
			throw new CollegeException("College is not present");
		return clg;
	}

}
