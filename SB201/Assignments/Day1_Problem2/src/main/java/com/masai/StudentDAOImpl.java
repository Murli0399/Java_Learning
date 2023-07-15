package com.masai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

	public Student getStudentByRollNo(int rollNo) throws StudentException {
		Connection conn;
		try {
			conn = DBUtils.getConnectionTodatabase();

			PreparedStatement ps = conn.prepareStatement("select * from Student where rollNo = ?");
			ps.setInt(1, rollNo);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}

		} catch (Exception ex) {

		}
		return null;
	}

	public List<Student> getAllStudent() {
		Connection conn;
		List<Student> list = null;
		try {
			conn = DBUtils.getConnectionTodatabase();

			PreparedStatement ps = conn.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();

			list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}

		} catch (Exception ex) {

		}
		return list;
	}

	public String saveStudentDetails(Student student) {
		Connection conn;
		String res = "Unable to Registration";
		try {
			conn = DBUtils.getConnectionTodatabase();

			PreparedStatement ps = conn
					.prepareStatement("Insert into student (studentName, address, marks) values(?, ?, ?)");
			ps.setString(1, student.getStudentName());
			ps.setString(2, student.getAddress());
			ps.setInt(3, student.getMarks());

			int x = ps.executeUpdate();

			if (x > 0) {
				res = "Registration Successfull";
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return res;
	}

	public String deleteStudentByRollNo(int rollNo) throws StudentException {
		Connection conn;
		String res = "Unable to Delete";
		try {
			conn = DBUtils.getConnectionTodatabase();

			PreparedStatement ps = conn.prepareStatement("delete from student where rollNo = ?");

			ps.setInt(1, rollNo);

			int x = ps.executeUpdate();

			if (x > 0) {
				res = "Delete Successfull";
			}

		} catch (Exception ex) {

		}

		return res;
	}

	public String graceStudentMarks(int rollNo, int marks) throws StudentException {
		Connection conn;
		String res = "Unable to Update";
		try {
			conn = DBUtils.getConnectionTodatabase();

			PreparedStatement ps = conn.prepareStatement("update student set marks = ? where rollNo = ?");

			ps.setInt(1, marks);
			ps.setInt(2, rollNo);

			int x = ps.executeUpdate();

			if (x > 0) {
				res = "Update Successfull";
			}

		} catch (Exception ex) {

		}

		return res;
	}

	public Student getStudentsByName(String name) throws StudentException {
		Connection conn;
		try {
			conn = DBUtils.getConnectionTodatabase();

			PreparedStatement ps = conn.prepareStatement("select * from Student where studentName = ?");
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}

		} catch (Exception ex) {

		}
		return null;
	}

}
