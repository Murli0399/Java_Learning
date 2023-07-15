package usecases;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import model.Address;
import model.Customer;
import util.EMUtils;

public class InsertDataMain {
	public static void main(String[] args) {
		EntityManager em = EMUtils.getEntityManager();

		Address homeAdd1 = new Address("MP", "Khandwa", "450001");
		Address officeAdd1 = new Address("Delhi", "Delhi", "556561");
		List<Address> add1 = new ArrayList<>();
		add1.add(homeAdd1);
		add1.add(officeAdd1);
		Customer c1 = new Customer("Murli", "8462858556", "murlikhaire@gmail", add1);

		Address homeAdd2 = new Address("GJ", "Surat", "450001");
		Address officeAdd2 = new Address("MH", "Mumbai", "556561");
		List<Address> add2 = new ArrayList<>();
		add2.add(homeAdd2);
		add2.add(officeAdd2);
		Customer c2 = new Customer("Rahul", "5452858556", "rahul@gmail", add2);

		em.getTransaction().begin();
		em.persist(c1);
		em.persist(c2);
		em.getTransaction().commit();
		em.close();

	}
}
