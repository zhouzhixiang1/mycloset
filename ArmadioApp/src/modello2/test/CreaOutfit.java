package modello2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import utility.CreazioneOutfit;
import utility.TrovaStagione;
import variabiliApp.Variabili;

public class CreaOutfit {

	@Test
	public void test() {
		
		String stagione = TrovaStagione.stagione(Variabili.mese);
		
		CreazioneOutfit.creaOutfit(stagione, Variabili.feriale);
		
		
	}

}
