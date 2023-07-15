package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.DepartmentDTO;
import com.masai.dto.DepartmentDTOImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrong;

public class DepartmentDAOImpl implements DepartmentDAO {

	@Override
	public void addDepartment(DepartmentDTO depDto) throws SomethingWentWrong {

		Connection conn = null;

		try {
			conn = DBUtils.getConnectionTodatabase();

			String query = "insert into department (dname, location) values (?, ?)";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, depDto.getDname());
			ps.setString(2, depDto.getLocation());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrong("Unable to add Department");
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException ex) {

			}
		}
	}

	@Override
	public void deleteDepartment(int id) throws SomethingWentWrong {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();

			String query = "delete from department where did = ? AND is_delete = 0";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException ex) {
//			System.out.println(ex.getMessage());
			throw new SomethingWentWrong("Unable to Delete");
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException ex) {

			}
		}
	}

	@Override
	public List<DepartmentDTO> viewDepartment() throws SomethingWentWrong, NoRecordFoundException {
		Connection conn = null;
		List<DepartmentDTO> list;
		try {
			conn = DBUtils.getConnectionTodatabase();

			String query = "select * from department d join employee e ON d.did = e.deptid where e.address = 'mumbai";

			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No Department Found");
			}
			list = new ArrayList<>();
			while (rs.next()) {
				list.add(new DepartmentDTOImpl(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

		} catch (ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrong("No Department Found");
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException ex) {

			}
		}

		return list;
	}

}
