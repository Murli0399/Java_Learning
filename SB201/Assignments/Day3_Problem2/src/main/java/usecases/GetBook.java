package usecases;


import com.masai.Book;
import com.masai.BookDAO;
import com.masai.BookDAOImpl;

public class GetBook {
	public static void main(String[] args) {

		BookDAO dao = new BookDAOImpl();
		Book book = dao.getBook(1);
		System.out.println(book.toString());

	}
}
