package usecases;

import javax.persistence.EntityManager;

import model.FullTimeStudent;
import model.PartTimeStudent;
import util.EMUtils;

public class InsertStudent {
	public static void main(String[] args) {
		PartTimeStudent pt1 = new PartTimeStudent();
		pt1.setName("Murli");
		pt1.setAddress("123 Main Street");
		pt1.setRegistrationFee(1000.0);
		pt1.setPartTimeFee(5000.0);
		
		PartTimeStudent pt2 = new PartTimeStudent();
		pt2.setName("Rahul");
		pt2.setAddress("456 Park Avenue");
		pt2.setRegistrationFee(1500.0);
		pt2.setPartTimeFee(6000.0);
		
		FullTimeStudent ft1 = new FullTimeStudent();
		ft1.setName("Shalu");
		ft1.setAddress("789 Broadway");
		ft1.setRegistrationFee(2000.0);
		ft1.setFullTimeFee(10000.0);
		
		FullTimeStudent ft2 = new FullTimeStudent();
		ft2.setName("Heer");
		ft2.setAddress("1010 Fifth Avenue");
		ft2.setRegistrationFee(2500.0);
		ft2.setFullTimeFee(12000.0);
		
		EntityManager em = EMUtils.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(pt1);
		em.persist(pt2);
		em.persist(ft1);
		em.persist(ft2);
		em.getTransaction().commit();
		em.close();
	}
}
