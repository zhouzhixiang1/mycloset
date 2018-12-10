package utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {
	
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mycloset");
    
    public static EntityManager getEntityManager(){
		EntityManager em = emf.createEntityManager();
		return em;
	}

}
