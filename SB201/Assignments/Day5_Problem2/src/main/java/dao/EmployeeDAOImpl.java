package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import exception.EmployeeException;
import util.EMUtils;

public class EmployeeDAOImpl implements EmployeeDAO {

	public List<Employee> getAllEmployees() throws EmployeeException {
		EntityManager em = EMUtils.getEntityManager();
		Query query = em.createNamedQuery("getAllEmployees");
		List<Employee> list = query.getResultList();
		em.close();
		return list;
	}

	public List<Employee> getEmployeesByAddress(String address) throws EmployeeException {
		EntityManager em = EMUtils.getEntityManager();
		Query query = em.createQuery("SELECT e FROM Employee e WHERE e.address = :address");
        query.setParameter("address", address);
        List<Employee> list = query.getResultList();
        em.close();
        return list;
	}

	public List<Employee> getAllEmployeeWithRangeSalary(int startSalary, int endSalary) throws EmployeeException {
		EntityManager em = EMUtils.getEntityManager();
		Query query = em.createQuery("SELECT e FROM Employee e WHERE e.salary BETWEEN :startSalary AND :endSalary");
        query.setParameter("startSalary",startSalary);
        query.setParameter("endSalary",endSalary);
        List<Employee> list = query.getResultList();
        em.close();
        return list;
	}

	public Object[] getEmployeeNameAndSalary(int empId) throws EmployeeException {
		EntityManager em = EMUtils.getEntityManager();
		Query query = em.createNamedQuery("getEmployeeNameAndSalary");
		query.setParameter(1, empId);
		Object[] list = (Object[]) query.getSingleResult();
		em.close();
		return list;
	}

	public int getEmployeeSalaryById(int empId) throws EmployeeException {
		EntityManager em = EMUtils.getEntityManager();
		Query query = em.createQuery("SELECT e.salary FROM Employee e WHERE e.empID = ?1");
        query.setParameter(1, empId);
        int salary = (int) query.getSingleResult();
        em.close();
        return salary;
	}

}
