package usecases;

import com.masai.CourtDAO;
import com.masai.CourtDAOImpl;

public class UpdateLawyer {
	public static void main(String[] args) {
		CourtDAO dao = new CourtDAOImpl();

		System.out.println(dao.updateLawyerExperience(2, 2));
	}
}
