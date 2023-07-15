package com.masai;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MasaiDAOImpl implements MasaiDAO {
	private EntityManagerFactory emf;

	public MasaiDAOImpl() {
		emf = Persistence.createEntityManagerFactory("masaiUnit");
	}

	public Student findStudentById(int id) {
		EntityManager em = emf.createEntityManager();
		Student student = em.find(Student.class, id);
		em.close();
		return student;
	}

	public String saveStudent(Student student) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
		em.close();
		return "Student saved successfully!";
	}

	public String deleteStudentById(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Student student = em.find(Student.class, id);
		if (student != null) {
			em.remove(student);
			em.getTransaction().commit();
			em.close();
			return "Student Deleted Successful";
		} else {
			em.getTransaction().commit();
			em.close();
			return "Student not Found";
		}
	}

	public String updateStudentLevel(int id, int level) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Student student = em.find(Student.class, id);
		if (student != null) {
			student.setLevel(level);
			em.getTransaction().commit();
			em.close();
			return "Student updated successfull";
		} else {
			em.getTransaction().commit();
			em.close();
			return "Unable to Update Student";
		}
	}

}
