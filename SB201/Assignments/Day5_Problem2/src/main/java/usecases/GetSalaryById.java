package usecases;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import exception.EmployeeException;

public class GetSalaryById {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAOImpl();
		try {
			int salary = dao.getEmployeeSalaryById(1);
			System.out.println(salary);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
