package usecases;

import java.time.LocalDateTime;

import com.masai.Book;
import com.masai.BookDAO;
import com.masai.BookDAOImpl;

public class SaveBook {
	public static void main(String[] args) {
		
		Book newBook = new Book();
		newBook.setName("Java");
		newBook.setAuthor("John");
		newBook.setPublication("Tech Publication");
		newBook.setCategory("Computer Programming");
		newBook.setPages(1000);
		newBook.setPrice(200);
		newBook.setTimestamp(LocalDateTime.now());
		
		BookDAO dao = new BookDAOImpl();
		
		System.out.println(dao.saveBook(newBook));
		
	}
}
