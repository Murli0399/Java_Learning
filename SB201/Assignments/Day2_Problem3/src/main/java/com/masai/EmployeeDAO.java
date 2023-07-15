package com.masai;

public interface EmployeeDAO {
	public String registerEmployee(Employee employee);

	public Employee getEmployeeById(int empId);

	public String deleteEmployeeById(int empId);

	public String updateEmployeeSalary(int empId, int amount);
}
