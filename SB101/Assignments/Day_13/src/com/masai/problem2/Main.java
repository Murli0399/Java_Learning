package com.masai.problem2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {

	static Connection getConnectionTodatabase() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResourceBundle rb = ResourceBundle.getBundle("dbdetails");
		return DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
	}

	static void closeConnection(Connection conn) throws SQLException {
		if (conn != null)
			conn.close();
	}

	static void addBook(Scanner sc) throws SQLException, ClassNotFoundException {
		Connection conn = getConnectionTodatabase();

		Statement st = conn.createStatement();

		System.out.print("Please enter book id : ");
		int bid = sc.nextInt();

		System.out.print("Please enter book Name : ");
		String name = sc.next();

		System.out.print("Please enter book Price : ");
		double price = sc.nextDouble();

		System.out.print("Please enter book Author : ");
		String author = sc.next();

		System.out.print("Please enter book Publish Year : ");
		String year = sc.next();

		String query = "Insert into book values('" + bid + "','" + name + "','" + price + "','" + author + "' ,'" + year
				+ "')";

		if (st.executeUpdate(query) > 0) {
			System.out.println("Book added successfully");
		} else {
			System.out.println("Not able to add Book");
		}
		System.out.println("---------------------------------------------------------");

		conn.close();
	}

	static void searchBook() throws SQLException, ClassNotFoundException {
		Connection conn = getConnectionTodatabase();

		Statement st = conn.createStatement();

		String query = "Select * from book where bookPrice >= '" + 1000.0 + "' && bookPrice <= '" + 2000.0 + "'";

		ResultSet rs = st.executeQuery(query);

		if (!rs.isBeforeFirst() && rs.getRow() == 0) {
			System.out.println("No Book Found");
		} else {
			System.out.println("Book Details :- ");
			while (rs.next()) {
				System.out.println("Book ID = " + rs.getInt(1) + ", Book Name = " + rs.getString(2) + ", Book Price = "
						+ rs.getDouble(3) + ", Author Name = " + rs.getString(4) + ", Publish Year = "
						+ rs.getString(5));
			}
		}
		System.out.println("---------------------------------------------------------");
		conn.close();
	}

	static void bookByAythor(Scanner sc) throws SQLException, ClassNotFoundException {
		Connection conn = getConnectionTodatabase();

		Statement st = conn.createStatement();

		System.out.print("Enter Author Name : ");
		String a = sc.next();

		String query = "Select * from book where bookAuthor = '" + a + "'";

		ResultSet rs = st.executeQuery(query);

		if (!rs.isBeforeFirst() && rs.getRow() == 0) {
			System.out.println("No Books available for this author");
		} else {
			System.out.println("Book Details :- ");
			while (rs.next()) {
				System.out.println("Book ID = " + rs.getInt(1) + ", Book Name = " + rs.getString(2) + ", Book Price = "
						+ rs.getDouble(3) + ", Author Name = " + rs.getString(4) + ", Publish Year = "
						+ rs.getString(5));
			}
		}
		System.out.println("---------------------------------------------------------");
		conn.close();
	}

	static void deleteBook(Scanner sc) throws ClassNotFoundException, SQLException {
		Connection conn = getConnectionTodatabase();

		Statement st = conn.createStatement();

		System.out.print("Enter Book Id : ");
		int bid = sc.nextInt();

		String query = "DELETE FROM book WHERE bookID = " + bid + "";

		if (st.executeUpdate(query) > 0) {
			System.out.println("Book deleted successfully...");
		} else {
			System.out.println("Invalid Book Id...");
		}
		System.out.println("---------------------------------------------------------");

		conn.close();
	}

	static void updateAuthor(Scanner sc) throws SQLException, ClassNotFoundException {
		Connection conn = getConnectionTodatabase();

		Statement st = conn.createStatement();

		System.out.print("Please enter Book Id : ");
		String bid = sc.next();

		System.out.print("Please enter new Author Name : ");
		String au = sc.next();

		String query = "UPDATE book SET bookAuthor = '" + au + "' where bookId = " + bid + "";

		if (st.executeUpdate(query) > 0) {
			System.out.println("Author Name updated succefully...");
		} else {
			System.out.println("Book Id not available...");
		}
		System.out.println("---------------------------------------------------------");

		conn.close();
	}

	static void printBookByYear(Scanner sc) throws SQLException, ClassNotFoundException {
		Connection conn = getConnectionTodatabase();

		Statement st = conn.createStatement();

		System.out.print("Enter Publish Year : ");
		String year = sc.next();

		String query = "Select * from book where publishYear = '" + year + "'";

		ResultSet rs = st.executeQuery(query);

		if (!rs.isBeforeFirst() && rs.getRow() == 0) {
			System.out.println("No Book Found");
		} else {
			System.out.println("Book Details :- ");
			while (rs.next()) {
				System.out.println("Book ID = " + rs.getInt(1) + ", Book Name = " + rs.getString(2) + ", Book Price = "
						+ rs.getDouble(3) + ", Author Name = " + rs.getString(4) + ", Publish Year = "
						+ rs.getString(5));
			}
		}
		System.out.println("---------------------------------------------------------");
		conn.close();
	}

	static void printAllBook() throws SQLException, ClassNotFoundException {
		Connection conn = getConnectionTodatabase();

		Statement st = conn.createStatement();

		String query = "Select * from book";

		ResultSet rs = st.executeQuery(query);

		if (!rs.isBeforeFirst() && rs.getRow() == 0) {
			System.out.println("No Book Found");
		} else {
			System.out.println("Book Details :- ");
			while (rs.next()) {
				System.out.println("Book ID = " + rs.getInt(1) + ", Book Name = " + rs.getString(2) + ", Book Price = "
						+ rs.getDouble(3) + ", Author Name = " + rs.getString(4) + ", Publish Year = "
						+ rs.getString(5));
			}
		}
		System.out.println("---------------------------------------------------------");
		conn.close();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		System.out.println("***Welcome to our application***");

		int choice = 0;
		do {
			System.out.println("1. Add Book");
			System.out.println("2. Search Book between 1000 to 2000");
			System.out.println("3. Search Book by Author Name");
			System.out.println("4. Delete Book by ID");
			System.out.println("5. Change Author Name");
			System.out.println("6. View Book By Publish Year");
			System.out.println("7. Display All Books");

			System.out.println("0. Exit");

			System.out.print("Enter selection : ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				addBook(sc);
				break;
			case 2:
				searchBook();
				break;
			case 3:
				bookByAythor(sc);
				break;
			case 4:
				deleteBook(sc);
				break;
			case 5:
				updateAuthor(sc);
				break;
			case 6:
				printBookByYear(sc);
				break;
			case 7:
				printAllBook();
				break;
			case 0:
				System.out.println("Thnaks for using our services");
				break;
			}

		} while (choice != 0);

		sc.close();
	}
}
