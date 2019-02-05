package modello2.test;

import org.junit.Test;

import utility.CreazioneOutfit;
import utility.EntityManagerProvider;

public class EntityManagerTest {

	@Test
	public void test() {
		EntityManagerProvider.getEntityManager();
		
		CreazioneOutfit.creaOutfit();
		System.out.print("CIAO");
	}

}
