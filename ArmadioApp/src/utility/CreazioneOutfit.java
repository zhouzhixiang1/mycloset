package utility;

import variabiliApp.Variabili;

public class CreazioneOutfit {
	
	public static void creaOutfit() {
		String stagione = TrovaStagione.stagione(Variabili.mese);
		Boolean feriale = Variabili.feriale;
		if(feriale) {
			String puntatore = stagione+"Feriale";
			System.out.println(puntatore);
		}
		
	}

}
