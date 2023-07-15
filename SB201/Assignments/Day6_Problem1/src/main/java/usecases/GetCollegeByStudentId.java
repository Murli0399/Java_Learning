package usecases;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.College;
import util.EMUtils;

public class GetCollegeByStudentId {
	public static void main(String[] args) {
		EntityManager em = EMUtils.getEntityManager();
		TypedQuery<College> collegeQuery = em.createQuery("SELECT c FROM College c WHERE c.collegeId = (SELECT s.college.collegeId FROM Student s WHERE s.studentRoll = :studentRoll)", College.class);
		collegeQuery.setParameter("studentRoll", 1);
        
        List<College> list = collegeQuery.getResultList();
        
        for(College i : list) {
        	System.out.println(i.getCollageId()+" "+i.getCollageName()+" "+i.getCollageAddress());
        }
        
	}
}
