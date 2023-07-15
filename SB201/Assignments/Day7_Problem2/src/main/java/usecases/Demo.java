package usecases;

import java.util.List;

import javax.persistence.EntityManager;

import model.MasaiStudent;
import util.EMUtils;

public class Demo {
	public static void main(String[] args) {
		EntityManager em = EMUtils.getEntityManager();

		String name = "Murli";

		List<MasaiStudent> students = em.createQuery("FROM MasaiStudent s WHERE s.name = :name")
				.setParameter("name", name).getResultList();

		if (students.size() == 0) {
			System.out.println("Student Not Found");
		} else {
			MasaiStudent student = students.get(0);
			student.displayDetails();

			double fee = student.payFee();
			System.out.println(fee);
		}

	}
}
