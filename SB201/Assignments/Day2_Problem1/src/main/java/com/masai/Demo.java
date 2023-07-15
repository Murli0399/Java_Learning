package com.masai;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo {

	public static void main(String[] args) {
		
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("product");
		
			EntityManager em= emf.createEntityManager();
			
			Product product = em.find(Product.class, 2);
	        if (product != null) {
	            System.out.println("Product found: " + product.getProductName());
	        } else {
	            System.out.println("Product not found");
	        }

	        em.close();
	}
}
