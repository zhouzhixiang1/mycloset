package modello;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import loginmanager.AccessoApplicazione;

public class Programma {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mycloset");
		EntityManager em = emf.createEntityManager();
		Guardaroba r = new Guardaroba();
		Utente u = new Utente();
		u.setEmail("utente@prova.com");
		u.setPassword("1234");
		u.setAttivo(true);
		u.setGuardaroba(r);
		r.setUtente(u);
		em.getTransaction().begin();
		em.persist(u);
		em.persist(r);
		em.getTransaction().commit();
		
		String email = sc.nextLine();
		String password = sc.nextLine();
		
		AccessoApplicazione.login(email, password);
		
		}

}
