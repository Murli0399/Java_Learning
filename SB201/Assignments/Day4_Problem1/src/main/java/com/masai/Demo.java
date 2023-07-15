package com.masai;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class Demo {
	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("player-unit");
		EntityManager em = emfactory.createEntityManager();

//		Write a Query That will return the list of player names in Upper case (Scalar function) 
		Query query = em.createQuery("select UPPER(p.Name) from Player p");

		List<String> list = query.getResultList();
		list.forEach(System.out::println);

//		Write a Query That will give a min age of a player out of all players. (Aggregate function)
		Query query2 = em.createQuery("select min(p.Age) from Player p");
		System.out.println(query2.getSingleResult());

//		Write a Query  That will give a list of players with an age group between 18 to 25 years. (Between)
		Query query3 = em.createQuery("select p from Player p");
		List<Player> list3 = query3.getResultList();
		for(Player p : list3) {
			System.out.println(p.toString());
		}
		
//		Write a Query that will return the name of players whose names start with a particular letter. (Like) 
		Query query4 = em.createQuery("select p.Name from Player p where p.Name LIKE 'r%'");

		List<String> list4 = query4.getResultList();
		list4.forEach(System.out::println);
	}
}
