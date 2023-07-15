package usecases;

import com.masai.BookDAO;
import com.masai.BookDAOImpl;

public class UpdatePrice {
	public static void main(String[] args) {

		BookDAO dao = new BookDAOImpl();
		System.out.println(dao.updateBook(1));

	}
}
