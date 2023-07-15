package usecases;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Student;
import util.EMUtils;

public class GetAllStudentByCollegeId {
	public static void main(String[] args) {
		EntityManager em = EMUtils.getEntityManager();
		Query studentQuery = em.createQuery("SELECT s FROM Student s WHERE s.college.collegeId = :collageId",
				Student.class);
		studentQuery.setParameter("collageId", 1);
		List<Student> students = studentQuery.getResultList();

		for(Student s : students) {
			System.out.println(s.getStudentName()+" "+s.getStudentRoll()+" "+s.getEmail()+" "+s.getMobileNumber()+" "+s.getCollege().getCollageAddress());
		}

		em.close();
	}
}
