package com.masai.Problem1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	static void addProduct(Scanner sc) throws SQLException, ClassNotFoundException {
		Connection conn = getConnectionTodatabase();

		String query = "Insert into product values(?,?,?,?)";

		PreparedStatement ps = conn.prepareStatement(query);

		System.out.print("Please enter Product Id : ");
		int pid = sc.nextInt();

		System.out.print("Please enter Product Name : ");
		String name = sc.next();

		System.out.print("Please enter Product Quantity : ");
		int qty = sc.nextInt();

		System.out.print("Please enter Product Price : ");
		int price = sc.nextInt();

		ps.setInt(1, pid);
		ps.setString(2, name);
		ps.setInt(3, qty);
		ps.setInt(4, price);

		if (ps.executeUpdate() > 0) {
			System.out.println("Product added successfully");
		} else {
			System.out.println("Not able to add Product");
		}
		System.out.println("---------------------------------------------------------");

		conn.close();
	}

	static void addProductDetail(Scanner sc) throws SQLException, ClassNotFoundException {
		Connection conn = getConnectionTodatabase();

		String query = "Insert into product values(?,?,0,0)";

		PreparedStatement ps = conn.prepareStatement(query);

		System.out.print("Please enter Product Id : ");
		int pid = sc.nextInt();

		System.out.print("Please enter Product Name : ");
		String name = sc.next();

		ps.setInt(1, pid);
		ps.setString(2, name);

		if (ps.executeUpdate() > 0) {
			System.out.println("Product added successfully");
		} else {
			System.out.println("Not able to add Product");
		}
		System.out.println("---------------------------------------------------------");

		conn.close();
	}

	static void updateProduct(Scanner sc) throws SQLException, ClassNotFoundException {
		Connection conn = getConnectionTodatabase();

		String query = "update product set quantity = ? , price = ? where pid = ?";

		PreparedStatement ps = conn.prepareStatement(query);

		System.out.print("Please enter Product Id : ");
		int pid = sc.nextInt();

		System.out.print("Please enter Product Quantity : ");
		int qty = sc.nextInt();

		System.out.print("Please enter Product Price : ");
		int price = sc.nextInt();

		ps.setInt(1, qty);
		ps.setInt(2, price);
		ps.setInt(3, pid);

		if (ps.executeUpdate() > 0) {
			System.out.println("Product updated successfully");
		} else {
			System.out.println("Not able to update Product");
		}
		System.out.println("---------------------------------------------------------");

		conn.close();
	}

	static void deleteProduct() throws ClassNotFoundException, SQLException {
		Connection conn = getConnectionTodatabase();

		String query = "delete from product where quantity < 2";

		PreparedStatement ps = conn.prepareStatement(query);

		if (ps.executeUpdate() > 0) {
			System.out.println("Products deleted successfully");
		} else {
			System.out.println("Unable to delete Product");
		}

		conn.close();
	}

	static void viewProduct() throws ClassNotFoundException, SQLException {
		Connection conn = getConnectionTodatabase();

		String query = "select * from product";

		PreparedStatement ps = conn.prepareStatement(query);

		ResultSet rs = ps.executeQuery();

		if (!rs.isBeforeFirst() && rs.getRow() == 0) {
			System.out.println("No Product Found");
		} else {
			while (rs.next()) {
				System.out.print("Product Id : " + rs.getInt(1));
				System.out.print(" Name: " + rs.getString(2));
				System.out.print(" Quantity : " + rs.getInt(3));
				System.out.println(" Price : " + rs.getInt(4));
			}
		}

		conn.close();
	}

	static void searchByName(Scanner sc) throws ClassNotFoundException, SQLException {
		Connection conn = getConnectionTodatabase();

		String query = "select * from product where pname = ?";

		PreparedStatement ps = conn.prepareStatement(query);

		System.out.print("Please enter Product Name : ");
		String name = sc.next();

		ps.setString(1, name);

		ResultSet rs = ps.executeQuery();

		if (!rs.isBeforeFirst() && rs.getRow() == 0) {
			System.out.println("No Product Found");
		} else {
			while (rs.next()) {
				System.out.print("Product Id : " + rs.getInt(1));
				System.out.print(", Name: " + rs.getString(2));
				System.out.print(", Quantity : " + rs.getInt(3));
				System.out.println(", Price : " + rs.getInt(4));
			}
		}

		conn.close();
	}

	static void searchByRange(Scanner sc) throws ClassNotFoundException, SQLException {
		Connection conn = getConnectionTodatabase();

		String query = "select * from product where price between ? and ?";

		PreparedStatement ps = conn.prepareStatement(query);

		System.out.print("Please enter first Price : ");
		int p1 = sc.nextInt();

		System.out.print("Please enter second Price : ");
		int p2 = sc.nextInt();

		ps.setInt(1, p1);
		ps.setInt(2, p2);

		ResultSet rs = ps.executeQuery();

		if (!rs.isBeforeFirst() && rs.getRow() == 0) {
			System.out.println("No Product Found");
		} else {
			while (rs.next()) {
				System.out.print("Product Id : " + rs.getInt(1));
				System.out.print(", Name: " + rs.getString(2));
				System.out.print(", Quantity : " + rs.getInt(3));
				System.out.println(", Price : " + rs.getInt(4));
			}
		}

		conn.close();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		System.out.println("***Welcome to our application***");

		int choice = 0;
		do {
			System.out.println("1. Add Product");
			System.out.println("2. Add Product without quantity and price");
			System.out.println("3. Update Product by Id");
			System.out.println("4. Delete Product whose quantity is less then 2");
			System.out.println("5. View all Product Details");
			System.out.println("6. View Product By Name");
			System.out.println("7. View Product By Price Range");

			System.out.println("0. Exit");

			System.out.print("Enter selection : ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				addProduct(sc);
				break;
			case 2:
				addProductDetail(sc);
				break;
			case 3:
				updateProduct(sc);
				break;
			case 4:
				deleteProduct();
				break;
			case 5:
				viewProduct();
				break;
			case 6:
				searchByName(sc);
				break;
			case 7:
				searchByRange(sc);
				break;
			case 0:
				System.out.println("Thnaks for using our services");
				break;
			}

		} while (choice != 0);

		sc.close();
	}
}
