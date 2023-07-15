package com.masai.problem1;

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

	static void updateData(Scanner sc) throws SQLException, ClassNotFoundException {
		Connection conn = getConnectionTodatabase();

		Statement st = conn.createStatement();

		System.out.print("Please enter your customer id : ");
		String cid = sc.next();

		System.out.print("Please enter your wallet balance : ");
		double wb = sc.nextDouble();

		System.out.print("Please enter your date of joining (YYYY-MM-DD) : ");
		LocalDate doj = LocalDate.parse(sc.next());

		String query = "UPDATE customer SET wallet_balance = " + wb + ", date_of_joining = '" + doj
				+ "' where customerID = '" + cid + "'";

		if (st.executeUpdate(query) > 0) {
			System.out.println("Details updated succefully...");
		} else {
			System.out.println("Not able to update data...");
		}
		System.out.println("---------------------------------------------------------");

		conn.close();
	}

	static void addCustomer(Scanner sc) throws SQLException, ClassNotFoundException {
		Connection conn = getConnectionTodatabase();

		Statement st = conn.createStatement();

		System.out.print("Please enter your customer id : ");
		String cid = sc.next();

		System.out.print("Please enter your name : ");
		String name = sc.next();

		System.out.print("Please enter your gender : ");
		String gen = sc.next();

		System.out.print("Please enter your wallet balance : ");
		double wb = sc.nextDouble();

		System.out.print("Please enter your date of joining (YYYY-MM-DD) : ");
		LocalDate doj = LocalDate.parse(sc.next());

		String query = "Insert into customer values('" + cid + "','" + name + "','" + gen + "'," + wb + ",'" + doj
				+ "')";

		if (st.executeUpdate(query) > 0) {
			System.out.println("Customer added successfully");
		} else {
			System.out.println("Not able to add Customer");
		}
		System.out.println("---------------------------------------------------------");

		conn.close();
	}

	static void deleteCustomer() throws ClassNotFoundException, SQLException {
		Connection conn = getConnectionTodatabase();

		Statement st = conn.createStatement();

		String query = "DELETE FROM customer WHERE wallet_balance = " + 0.0 + "";

		if (st.executeUpdate(query) > 0) {
			System.out.println("Customers deleted successfully");
		} else {
			System.out.println("Not have any customer");
		}
		System.out.println("---------------------------------------------------------");

		conn.close();
	}

	static void viewCustomer() throws ClassNotFoundException, SQLException {
		Connection conn = getConnectionTodatabase();

		Statement st = conn.createStatement();

		String query = "Select * from customer";

		ResultSet rs = st.executeQuery(query);

		if (!rs.isBeforeFirst() && rs.getRow() == 0) {
			System.out.println("No Customer Found");
		} else {
			System.out.println("Customer Details :- ");
			while (rs.next()) {
				System.out.println("Customer ID = " + rs.getString(1) + ", Customer Name = " + rs.getString(2)
						+ ", Gender = " + rs.getString(3) + ", Wallet Balance = " + rs.getDouble(4)
						+ ", Date of Joining = " + rs.getDate(5));
			}
		}
		System.out.println("---------------------------------------------------------");
		conn.close();
	}

	static void searchCustomer(Scanner sc) throws SQLException, ClassNotFoundException {
		Connection conn = getConnectionTodatabase();

		Statement st = conn.createStatement();

		System.out.println("Enter the range of date of joining (YYYY-MM-DD) ");
		System.out.println("Enter first Date : ");
		LocalDate doj1 = LocalDate.parse(sc.next());

		System.out.println("Enter second Date : ");
		LocalDate doj2 = LocalDate.parse(sc.next());

		String query = "Select * from customer where date_of_joining >= '" + doj1 + "' && date_of_joining <= '" + doj2
				+ "'";

		ResultSet rs = st.executeQuery(query);

		if (!rs.isBeforeFirst() && rs.getRow() == 0) {
			System.out.println("No Customer Found");
		} else {
			System.out.println("Customer Details :- ");
			while (rs.next()) {
				System.out.println("Customer ID = " + rs.getString(1) + ", Customer Name = " + rs.getString(2)
						+ ", Gender = " + rs.getString(3) + ", Wallet Balance = " + rs.getDouble(4)
						+ ", Date of Joining = " + rs.getDate(5));
			}
		}
		System.out.println("---------------------------------------------------------");
		conn.close();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);

		System.out.println("***Welcome to our application***");

		int choice = 0;
		do {
			System.out.println("1. Add Customer");
			System.out.println("2. Update Customer");
			System.out.println("3. Delete customers whose wallet balance is 0");
			System.out.println("4. View Customer List");
			System.out.println("5. Search Customers By date of joinig");
			System.out.println("0. Exit");

			System.out.print("Enter selection ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				addCustomer(sc);
				break;
			case 2:
				updateData(sc);
				break;
			case 3:
				deleteCustomer();
				break;
			case 4:
				viewCustomer();
				break;
			case 5:
				searchCustomer(sc);
				break;
			case 0:
				System.out.println("Thnaks for using our services");
				break;
			}

		} while (choice != 0);

		sc.close();
	}
}
