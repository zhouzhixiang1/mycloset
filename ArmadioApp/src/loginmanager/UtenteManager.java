package loginmanager;

import javax.persistence.EntityManager;

import modello.Utente;
import utility.EntityManagerProvider;

public class UtenteManager {

	public static void aggiungiUtente(Utente u) {
		EntityManager em = EntityManagerProvider.getEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
	}

	public void rimuoviUtente(Utente u) {

	}

	public static void modificaUtente(Utente u) {
		EntityManager em = EntityManagerProvider.getEntityManager();
		Utente db = em.find(Utente.class, u.getEmail());
		if (db != null) {
			em.getTransaction().begin();
			db.setAttivo(u.getAttivo());
			db.setPassword(u.getPassword());
			em.getTransaction().commit();
		}
	}
}
