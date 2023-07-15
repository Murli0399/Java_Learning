package usecases;

import com.masai.CourtDAO;
import com.masai.CourtDAOImpl;
import com.masai.Lawyer;

public class SaveLawyer {
	public static void main(String[] args) {
		Lawyer lr = new Lawyer();
		lr.setEmail("murlikhaire@");
		lr.setName("Murli");
		lr.setAddress("Khandwa");
		lr.setExperience(5);

		CourtDAO dao = new CourtDAOImpl();
		System.out.println(dao.saveLawyer(lr));

	}
}
