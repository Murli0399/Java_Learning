package com.masai;

public interface BookDAO {
	public Book getBook(int id);

	public String saveBook(Book book);

	public String deleteBook(int id);

	public String updateBook(int id);

}
