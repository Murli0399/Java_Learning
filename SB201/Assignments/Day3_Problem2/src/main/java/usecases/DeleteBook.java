package usecases;

import com.masai.BookDAO;
import com.masai.BookDAOImpl;

public class DeleteBook {
	public static void main(String[] args) {

		BookDAO dao = new BookDAOImpl();
		System.out.println(dao.deleteBook(1));

	}
}
