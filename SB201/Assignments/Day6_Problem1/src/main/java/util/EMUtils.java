package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtils {
	private static final EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("college-unit");
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
