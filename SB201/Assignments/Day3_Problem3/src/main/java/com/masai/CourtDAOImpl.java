package com.masai;

import javax.persistence.EntityManager;

public class CourtDAOImpl implements CourtDAO {

	public Lawyer findLawyerById(int id) {
		EntityManager em = EMUtils.getEntityManager();
		Lawyer obj = em.find(Lawyer.class, id);
		if (obj == null)
			throw new LawyerException("Lawyer Not Available");
		em.close();
		return obj;
	}

	public String saveLawyer(Lawyer lawyer) {
		if (lawyer == null)
			throw new LawyerException("Lawyer is Null");
		EntityManager em = EMUtils.getEntityManager();
		Lawyer obj = em.find(Lawyer.class, lawyer.getId());
		if (obj != null)
			throw new LawyerException("Lawyer is Already Present");
		em.getTransaction().begin();
		em.persist(lawyer);
		em.getTransaction().commit();
		em.close();
		return "Lawyer Added Successful";
	}

	public String deleteLawyerById(int id) {
		EntityManager em = EMUtils.getEntityManager();
		Lawyer obj = em.find(Lawyer.class, id);
		if (obj == null)
			throw new LawyerException("Lawyer Not Available");
		em.getTransaction().begin();
		em.remove(obj);
		em.getTransaction().commit();
		em.close();
		return "Lawyer Deleted Successful";
	}

	public String updateLawyerExperience(int id, int experience) {
		EntityManager em = EMUtils.getEntityManager();
		Lawyer obj = em.find(Lawyer.class, id);
		if (obj == null)
			throw new LawyerException("Lawyer Not Available");
		em.getTransaction().begin();
		obj.setExperience(obj.getExperience() + experience);
		em.getTransaction().commit();
		em.close();
		return "Lawyer Updated Successful";
	}

}
