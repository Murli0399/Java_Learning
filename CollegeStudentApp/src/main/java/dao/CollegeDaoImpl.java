package dao;

import java.util.List;

import entities.College;
import entities.Student;
import exceptions.CollegeException;
import exceptions.StudentException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utilities.EMUtil;

public class CollegeDaoImpl implements CollegeDao {

	@Override
	public College registerCollege(College college) throws CollegeException {
		if (college == null)
			throw new CollegeException("College obj is null");
		EntityManager em = EMUtil.provideEntityManager();
		College obj = em.find(College.class, college.getCollegeId());
		if (obj != null)
			throw new CollegeException("College is already present");
		em.getTransaction().begin();
		em.persist(college);
		em.getTransaction().commit();
		em.close();
		return college;
	}

	@Override
	public College getCollegeFromCollegeId(int collegeId) throws CollegeException {
		EntityManager em = EMUtil.provideEntityManager();
		College obj = em.find(College.class, collegeId);
		if (obj == null)
			throw new CollegeException("College is not present");

		em.close();
		return obj;
	}

	@Override
	public List<College> getAllCollege() throws CollegeException {
		EntityManager em = EMUtil.provideEntityManager();
		String q = "SELECT c FROM College c";
		Query obj = em.createQuery(q);
		List<College> list = obj.getResultList();
		if (list.isEmpty())
			throw new CollegeException("College is not present");
		return list;
	}

	@Override
	public Student registerStudentToCollege(int studentId, int collegeId) throws CollegeException, StudentException {
		EntityManager em = EMUtil.provideEntityManager();
		Student stu = em.find(Student.class, studentId);
		if (stu == null)
			throw new StudentException("Student is not present");
		College clg = em.find(College.class, collegeId);
		if (clg == null)
			throw new CollegeException("College is not present");
		em.getTransaction().begin();
		clg.getStudents().add(stu);
		stu.setCollege(clg);
		em.getTransaction().commit();
		return stu;
	}

	@Override
	public List<Student> getAllStudentsFromCollegeId(int collegeId) throws CollegeException, StudentException {
		EntityManager em = EMUtil.provideEntityManager();
		College obj = em.find(College.class, collegeId);
		if (obj == null)
			throw new CollegeException("College is not present");

		List<Student> students = obj.getStudents().stream().filter(a -> a.isStatus()).toList();
		if (students.isEmpty())
			throw new StudentException("Student not present");
		em.close();
		return students;

	}

}
