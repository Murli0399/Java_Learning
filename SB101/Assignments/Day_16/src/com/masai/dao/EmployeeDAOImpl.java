package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.EmployeeDTO;
import com.masai.dto.EmployeeDTOImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrong;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void addEmployee(EmployeeDTO empDto) throws SomethingWentWrong {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "INSERT INTO Employee(ename, address, mobile, deptid) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, empDto.getEname());
			ps.setString(2, empDto.getAddress());
			ps.setString(3, empDto.getMobile());
			ps.setInt(4, empDto.getDepyid());
			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrong("Unable to add Employee");
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException ex) {

			}
		}
	}

	@Override
	public List<EmployeeDTO> viewEmployeeAccount() throws SomethingWentWrong, NoRecordFoundException {
		Connection conn = null;
		List<EmployeeDTO> list;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "select * from employee e join department d ON e.deptid = d.did where d.dname = 'Account'";
			PreparedStatement ps = conn.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			if (DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("Not havae employee in Account Department");
			}

			list = new ArrayList<>();
			while (rs.next()) {
				list.add(new EmployeeDTOImpl(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5)));
			}

		} catch (ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrong("Unable to add Employee");
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException ex) {

			}
		}
		return list;
	}

}
