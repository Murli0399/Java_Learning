package com.masai;

import javax.persistence.EntityManager;

public class EmployeeDAOImpl implements EmployeeDAO {

	public void save(Employee emp) {
		if (emp == null)
			throw new EmployeeException("Null values Not added");
		EntityManager em = EMUtils.getEntityManager();
		Employee empObj = em.find(Employee.class, emp.getEmpId());
		if(empObj != null) throw new EmployeeException("Employee Already Present");
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		em.close();
		System.out.println("Employee Added Successful");
	}

	public String getAddressOfEmployee(int empId) {
		EntityManager em = EMUtils.getEntityManager();
		Employee emp = em.find(Employee.class, empId);
		if (emp == null)
			throw new EmployeeException("Employee Address not Found");
		em.close();
		return emp.getAddress();
	}

	public String giveBonusToEmployee(int empId, int bonus) {
		EntityManager em = EMUtils.getEntityManager();
		Employee emp = em.find(Employee.class, empId);
		if (emp == null)
			throw new EmployeeException("Employee not Found");
		em.getTransaction().begin();
		emp.setSalary(emp.getSalary()+bonus);
		em.getTransaction().commit();
		em.close();
		return "Bonus Updated";
	}

	public boolean deleteEmployee(int empId) {
		EntityManager em = EMUtils.getEntityManager();
		Employee emp = em.find(Employee.class, empId);
		if (emp == null)
			throw new EmployeeException("Employee not Found");
		em.getTransaction().begin();
		em.remove(emp);
		em.getTransaction().commit();
		em.close();
		return true;
	}

}
