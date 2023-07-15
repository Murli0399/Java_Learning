package com.masai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourtDAOImpl implements CourtDAO {

	@Override
	public Lawyer findLawyerById(int id) {
		Connection conn;
		try {
			conn = DBUtils.getConnectionTodatabase();

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Lawyer WHERE id = ?");

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Lawyer lawyer = new Lawyer(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("address"), rs.getInt("experience"));
				return lawyer;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String saveLawyer(Lawyer lawyer) {
		Connection conn;
		String res = null;
		try {
			conn = DBUtils.getConnectionTodatabase();

			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO Lawyer (name, email, address, experience) VALUES (?, ?, ?, ?)");
			ps.setString(1, lawyer.getName());
			ps.setString(2, lawyer.getEmail());
			ps.setString(3, lawyer.getAddress());
			ps.setInt(4, lawyer.getExperience());
			int count = ps.executeUpdate();
			if (count == 1)
				res = "Lawyer saved successfully";
			else
				res = "Failed to save lawyer";

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public String deleteLawyerById(int id) {
		Connection conn;
		String res = null;
		try {
			conn = DBUtils.getConnectionTodatabase();

			PreparedStatement ps = conn.prepareStatement("DELETE FROM Lawyer WHERE id = ?");
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			if (count == 1)
				res = "Lawyer deleted successfully";
			else
				res = "Failed to delete lawyer";

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public String updateLawyerExperience(int id, int experience) {
		Connection conn;
		String res = null;
		try {
			conn = DBUtils.getConnectionTodatabase();

			PreparedStatement ps = conn.prepareStatement("UPDATE Lawyer SET experience = ? WHERE id = ?");
			ps.setInt(1, experience);
			ps.setInt(2, id);
			int count = ps.executeUpdate();
			if (count == 1)
				res = "Lawyer experience updated successfully";
			else
				res = "Failed to update lawyer experience";

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

}
