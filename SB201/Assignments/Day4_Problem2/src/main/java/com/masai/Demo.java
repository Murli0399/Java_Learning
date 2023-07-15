package com.masai;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Demo {
	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("customer-unit");
		EntityManager em = emfactory.createEntityManager();
		
//		Write a NamedQuery to find “customer by id” by creating NamedQuery which will return customer details.
		Query query = em.createNamedQuery("findCustomerById");
		query.setParameter("id", 2);
		Customer cus = (Customer) query.getSingleResult();
		System.out.println(cus);
		
//		Write NativeQuery to get a “List of All the customers” by creating NamedQuery which will return all customer details.
		Query q = em.createNativeQuery("select * from Customer", Customer.class);
		
		List<Customer> cus1 = q.getResultList();
		cus1.forEach(System.out::println);
		
	}
}
