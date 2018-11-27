import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programma {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mycloset");
		EntityManager em = emf.createEntityManager();
		Guardaroba r = new Guardaroba();
		Utente u = new Utente();
		u.setEmail("utente@prova.com");
		u.setPassword("1234");
		r.setUtente(u);
		em.getTransaction().begin();
		em.persist(u);
		em.persist(r);
		em.getTransaction().commit();
	}

}
