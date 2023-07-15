package usecases;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import exception.EmployeeException;

public class GetEmployeeNameAndSalary {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAOImpl();
		try {
			Object[] list = dao.getEmployeeNameAndSalary(1);
			for(Object i : list) {
				System.out.print(i+" ");
			}
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
