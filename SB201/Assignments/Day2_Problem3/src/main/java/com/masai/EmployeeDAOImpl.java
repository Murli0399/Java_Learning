package com.masai;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManagerFactory emf;

	public EmployeeDAOImpl() {
		emf = Persistence.createEntityManagerFactory("employee");
	}

	public String registerEmployee(Employee employee) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
		em.close();
		return "Employee Register Successful";
	}

	public Employee getEmployeeById(int empId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Employee emp = em.find(Employee.class, empId);
		em.getTransaction().commit();
		em.close();
		return emp;
	}

	public String deleteEmployeeById(int empId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Employee emp = em.find(Employee.class, empId);
		if (emp != null) {
			em.remove(emp);
			em.getTransaction().commit();
			em.close();
			return "Employee Deleted Successful";
		} else {
			em.getTransaction().commit();
			em.close();
			return "Unable to Delete";
		}
	}

	public String updateEmployeeSalary(int empId, int amount) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Employee emp = em.find(Employee.class, empId);
		if (emp != null) {
			emp.setSalary(amount);
			em.getTransaction().commit();
			em.close();
			return "Employee Updated Successful";
		} else {
			em.getTransaction().commit();
			em.close();
			return "Unable to Update";
		}
	}

}
