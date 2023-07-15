package usecases;

import com.masai.CourtDAO;
import com.masai.CourtDAOImpl;
import com.masai.Lawyer;

public class FindLawyer {
	public static void main(String[] args) {
		CourtDAO dao = new CourtDAOImpl();
		Lawyer lr = dao.findLawyerById(2);
		System.out.println(lr.toString());
	}
}
