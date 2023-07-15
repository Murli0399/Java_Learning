import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public String registerEmployee(Employee employee) {
		Connection conn;
		String res = "Unable to Registration";
		try {
			conn = DBUtils.getConnectionTodatabase();

			PreparedStatement ps = conn
					.prepareStatement("Insert into employee (name, address, salary) values(?, ?, ?)");
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getAddress());
			ps.setInt(3, employee.getSalary());

			int x = ps.executeUpdate();

			if (x > 0) {
				res = "Registration Successfull";
			}

		} catch (Exception ex) {

		}

		return res;
	}

	@Override
	public Employee getEmployeeById(int empId) throws EmployeeException {
		Connection conn;
		try {
			conn = DBUtils.getConnectionTodatabase();

			PreparedStatement ps = conn.prepareStatement("select * from employee where empId = ?");
			ps.setInt(1, empId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}

		} catch (Exception ex) {

		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		Connection conn;
		List<Employee> list = null;
		try {
			conn = DBUtils.getConnectionTodatabase();

			PreparedStatement ps = conn.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();

			list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}

		} catch (Exception ex) {

		}
		return list;
	}

	@Override
	public String deleteEmployeeById(int empId) throws EmployeeException {
		Connection conn;
		String res = "Unable to Delete";
		try {
			conn = DBUtils.getConnectionTodatabase();

			PreparedStatement ps = conn.prepareStatement("delete from employee where empId = ?");

			ps.setInt(1, empId);

			int x = ps.executeUpdate();

			if (x > 0) {
				res = "Delete Successfull";
			}

		} catch (Exception ex) {

		}

		return res;
	}

	@Override
	public String giveBonusToEmployee(int empId, int amount) throws EmployeeException {
		Connection conn;
		String res = "Unable to Update";
		try {
			conn = DBUtils.getConnectionTodatabase();

			PreparedStatement ps = conn.prepareStatement("update employee set salary = ? where empId = ?");

			ps.setInt(1, amount);
			ps.setInt(2, empId);

			int x = ps.executeUpdate();

			if (x > 0) {
				res = "Update Successfull";
			}

		} catch (Exception ex) {

		}

		return res;
	}

}
