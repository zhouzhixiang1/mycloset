package modello2.test;

import javax.persistence.EntityManager;

import org.junit.Test;

import modello2.Alloggiamento;
import modello2.Armadio;
import modello2.Componente;
import modello2.Outfit;
import modello2.SpazioVestito;
import modello2.TipoOutfit;
import modello2.TipoVestito;
import modello2.Vestito;
import utility.CreaOutfit;
import utility.EntityManagerProvider;

public class PopolamentoEntitaTest {

	@Test
	public void test() {
		EntityManager em = EntityManagerProvider.getEntityManager();
		em.getTransaction().begin();
		
		TipoVestito tv1 = new TipoVestito();
		tv1.setNome("Mutande");
		em.persist(tv1);
		
		TipoVestito tv2 = new TipoVestito();
		tv2.setNome("Maglietta");
		em.persist(tv2);
		
		TipoVestito tv3 = new TipoVestito();
		tv3.setNome("Calzini");
		em.persist(tv3);
		
		TipoVestito tv4 = new TipoVestito();
		tv4.setNome("Giacca");
		em.persist(tv4);
		
		TipoVestito tv5 = new TipoVestito();
		tv5.setNome("Camicia");
		em.persist(tv5);
		
		TipoVestito tv6 = new TipoVestito();
		tv6.setNome("Pantalone");
		em.persist(tv6);
		
		TipoVestito tv7 = new TipoVestito();
		tv7.setNome("Cappello");
		em.persist(tv7);
		
		TipoVestito tv8 = new TipoVestito();
		tv8.setNome("Cappotto");
		em.persist(tv8);
		
		TipoOutfit to1 = new TipoOutfit();
		to1.setNome("Intimo");
		
		to1.addTipoVestito(tv1);
		to1.addTipoVestito(tv2);
		to1.addTipoVestito(tv3);
		
		em.persist(to1);
		
		TipoOutfit to2 = new TipoOutfit();
		to2.setNome("Sopra");
		to2.addTipoVestito(tv4);
		to2.addTipoVestito(tv5);
		to2.addTipoVestito(tv6);
		
		em.persist(to2);
		
		TipoOutfit to3 = new TipoOutfit();
		to3.setNome("Completo");
		to3.addTipoOutfit(to1);
		to3.addTipoOutfit(to2);
		
		SpazioVestito sv1 = new SpazioVestito();
		sv1.setNome("Mutande");
		sv1.setNumeroSpazi(10);
		
		SpazioVestito sv2 = new SpazioVestito();
		sv2.setNome("Magliette");
		sv2.setNumeroSpazi(5);
		
		SpazioVestito sv3 = new SpazioVestito();
		sv3.setNome("Calzini");
		sv3.setNumeroSpazi(15);
		
		SpazioVestito sv4 = new SpazioVestito();
		sv4.setNome("Pantaloni");
		sv4.setNumeroSpazi(10);
		
		SpazioVestito sv5 = new SpazioVestito();
		sv5.setNome("Giacche");
		sv5.setNumeroSpazi(3);
		
		SpazioVestito sv6 = new SpazioVestito();
		sv6.setNome("Camicie");
		sv6.setNumeroSpazi(10);

		Alloggiamento a1 = new Alloggiamento();
		a1.setNome("Scomparto 1");
		a1.addSpazioVesititi(sv1);
		a1.addSpazioVesititi(sv2);
		
		Componente c1 = new Componente();
		c1.setNome("Cassettiera 1");
		c1.addAlloggiamento(a1);
		Armadio arm1 = new Armadio();
		arm1.setNome("Armadio sala");
		arm1.addComponente(c1);
		
		em.persist(arm1);
		
		
		Vestito v1 = new Vestito();
		v1.setNome("Mutande Blu");
		tv1.addVestito(v1);
		sv1.addVestito(v1);
		
		Vestito v2 = new Vestito();
		v2.setNome("Maglietta rossa");
		tv2.addVestito(v2);
		sv2.addVestito(v2);
		
		Vestito v3 = new Vestito();
		v3.setNome("Calzini neri");
		tv3.addVestito(v3);
		
		Vestito v32 = new Vestito();
		v32.setNome("Calzini blu");
		tv3.addVestito(v32);
		
		Vestito v4 = new Vestito();
		v4.setNome("Jeans");
		tv4.addVestito(v4);
		
		Vestito v5 = new Vestito();
		v5.setNome("Giaccona verde");
		tv5.addVestito(v5);
		
		Vestito v6 = new Vestito();
		v6.setNome("Camicia azzurra");
		tv6.addVestito(v6);
		
		Outfit o1 = new Outfit();
		o1.setNome("invernale1");
		o1.setTipoOutfit(to3);
		
		em.persist(o1);
		
		Outfit o = new Outfit();
		o.setNome("InvernaleFeriale");
		o.addOutfit(o1);
		
		System.out.println("Esempio outfit:");
		LogInTest.test();
		em.getTransaction().commit();
		CreaOutfit.creaOutfitSerio();
		
	}

}
