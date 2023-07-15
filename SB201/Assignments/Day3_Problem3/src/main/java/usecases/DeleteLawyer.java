package usecases;

import com.masai.CourtDAO;
import com.masai.CourtDAOImpl;

public class DeleteLawyer {
	public static void main(String[] args) {
		CourtDAO dao = new CourtDAOImpl();

		System.out.println(dao.deleteLawyerById(2));
	}
}
