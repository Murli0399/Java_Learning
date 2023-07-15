package com.masai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class StudentDao {
	private DataSource dataSource;

	public StudentDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void addStudent(Student student) throws SQLException {
		String q = "INSERT INTO students (name, email) VALUES (?, ?)";
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(q)) {
			statement.setString(1, student.getName());
			statement.setString(2, student.getEmail());
			statement.executeUpdate();
		}
	}
}
