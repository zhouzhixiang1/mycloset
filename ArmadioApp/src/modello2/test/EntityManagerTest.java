package modello2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import utility.CreazioneOutfit;
import utility.EntityManagerProvider;
import utility.TrovaStagione;
import variabiliApp.Variabili;

public class EntityManagerTest {

	@Test
	public void test() {
		EntityManagerProvider.getEntityManager();
		
		CreazioneOutfit.creaOutfit();
		System.out.print("CIAO");
	}

}
