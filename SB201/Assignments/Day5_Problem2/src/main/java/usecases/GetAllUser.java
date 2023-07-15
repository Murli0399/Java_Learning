package usecases;

import java.util.List;

import dao.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import exception.EmployeeException;

public class GetAllUser {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAOImpl();
		List<Employee> list = null;
		try {
			list = dao.getAllEmployees();
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list.forEach(System.out::println);
		
	}
}
