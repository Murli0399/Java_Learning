package com.masai;

import javax.persistence.EntityManager;

public class BookDAOImpl implements BookDAO {

	public Book getBook(int id) {
		EntityManager em = EMUtils.getEntityManager();
		Book obj = em.find(Book.class, id);
		if (obj == null)
			throw new BookException("Book Not Available");
		em.close();
		return obj;
	}

	public String saveBook(Book book) {
		if (book == null)
			throw new BookException("Book is Null");
		EntityManager em = EMUtils.getEntityManager();
		Book obj = em.find(Book.class, book.getBookId());
		if (obj != null)
			throw new BookException("Book is Already Present");
		em.getTransaction().begin();
		em.persist(book);
		em.getTransaction().commit();
		em.close();
		return "Book Created Successful";
	}

	public String deleteBook(int id) {
		EntityManager em = EMUtils.getEntityManager();
		Book obj = em.find(Book.class, id);
		if (obj == null)
			throw new BookException("Book Not Available");
		em.getTransaction().begin();
		em.remove(obj);
		em.getTransaction().commit();
		em.close();
		return "Book Deleted Successful";
	}

	public String updateBook(int id) {
		EntityManager em = EMUtils.getEntityManager();
		Book obj = em.find(Book.class, id);
		if (obj == null)
			throw new BookException("Book Not Available");
		em.getTransaction().begin();
		obj.setPrice(obj.getPrice() * 2);
		em.getTransaction().commit();
		em.close();
		return "Book Price Updated Successful";
	}

}
