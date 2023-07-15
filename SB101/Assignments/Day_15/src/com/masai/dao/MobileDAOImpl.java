package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.Mobile;
import com.masai.dto.MobileImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrong;

public class MobileDAOImpl implements MobileDAO {

	public void addMobile(Mobile mob) throws SomethingWentWrong {

		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "Insert into mobile (model_no, company, price, mfgdate) values (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, mob.getModel_no());
			ps.setString(2, mob.getCompany());
			ps.setInt(3, mob.getPrice());
			ps.setDate(4, Date.valueOf(mob.getMfgdate()));
			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrong("Unable to add Mobile");
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException ex) {

			}
		}

	}

	public void updateMobile(Mobile mob) throws SomethingWentWrong {

		Connection conn = null;

		try {
			conn = DBUtils.getConnectionTodatabase();

			String query = "update mobile set company = ?, price = ?, mfgdate = ? where model_no = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, mob.getCompany());
			ps.setInt(2, mob.getPrice());
			ps.setDate(3, Date.valueOf(mob.getMfgdate()));
			ps.setString(4, mob.getModel_no());
			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrong("Unable to update Mobile");

		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException ex) {

			}
		}

	}

	public void deleteMobile(String model) throws SomethingWentWrong {
		Connection conn = null;

		try {
			conn = DBUtils.getConnectionTodatabase();

			String query = "delete from mobile where model_no = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, model);

			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrong("Mobile deleted successfully");

		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException ex) {

			}
		}
	}

	public List<Mobile> viewMobile() throws SomethingWentWrong, NoRecordFoundException {
		Connection conn = null;
		List<Mobile> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "SELECT * FROM mobile";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if (DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No Mobile found");
			}
			while (rs.next()) {
				list.add(new MobileImpl(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getDate(5).toLocalDate()));
			}

		} catch (ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrong("try again later");
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException ex) {

			}
		}
		return list;
	}

	public List<Mobile> searchByPriceRange(int a, int b) throws SomethingWentWrong, NoRecordFoundException {
		Connection conn = null;
		List<Mobile> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "SELECT * FROM mobile where price between ? AND ?";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, a);
			ps.setInt(2, b);

			ResultSet rs = ps.executeQuery();
			if (DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No Mobile found");
			}
			while (rs.next()) {
				list.add(new MobileImpl(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getDate(5).toLocalDate()));
			}

		} catch (ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrong("try again later");
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException ex) {

			}
		}
		return list;
	}

	public List<Mobile> searchByModel(String model) throws SomethingWentWrong, NoRecordFoundException {
		Connection conn = null;
		List<Mobile> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "SELECT * FROM mobile where nodel_no = ?";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, model);

			ResultSet rs = ps.executeQuery();
			if (DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No Mobile found");
			}
			while (rs.next()) {
				list.add(new MobileImpl(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getDate(5).toLocalDate()));
			}

		} catch (ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrong("try again later");
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException ex) {

			}
		}
		return list;
	}

}
