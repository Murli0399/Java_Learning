package usecases;

import java.util.List;

import dao.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import exception.EmployeeException;

public class GetEmployeeBySalaryRange {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAOImpl();
		List<Employee> list = null;
		try {
			list = dao.getAllEmployeeWithRangeSalary(45000, 60000);					
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		list.forEach(System.out::println);
	}
}
