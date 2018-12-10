package modello2.test;

import javax.persistence.EntityManager;

import org.junit.Test;

import modello2.Guardaroba;
import modello2.Utente;
import utility.EntityManagerProvider;

public class LogInTest {

	@Test
	public static void test() {
		EntityManager em = EntityManagerProvider.getEntityManager();
		em.getTransaction().begin();
		
		Utente u1 = new Utente();
		u1.setEmail("utente1@prova.com");
		u1.setPassword("1234");
		u1.setAttivo(true);
		u1.setGuardaroba(new Guardaroba());
		em.persist(u1);
		
		Utente u2 = new Utente();
		u2.setEmail("utente2@prova.com");
		u2.setPassword("12345");
		u2.setAttivo(true);
		u2.setGuardaroba(new Guardaroba());
		em.persist(u2);
		
		em.getTransaction().commit();
	}

}
