import java.util.List;

public interface EmployeeDAO {

			public String registerEmployee(Employee employee);
			
			public Employee getEmployeeById(int empId)throws EmployeeException;
			
			public List<Employee> getAllEmployee();
			
			public String deleteEmployeeById(int empId)throws EmployeeException;
			
			public String giveBonusToEmployee(int empId, int amount)throws EmployeeException;

}
