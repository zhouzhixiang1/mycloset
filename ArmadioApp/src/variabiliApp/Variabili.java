package variabiliApp;

import utility.TrovaStagione;

public class Variabili {
	
	public static boolean feriale = true;
	public static int mese = 12;
	public static int gradi;
	public static String temperatura;

	
	public boolean isFeriale() {
		return feriale;
	}
	public void setFeriale(boolean feriale) {
		this.feriale = feriale;
	}
	public int getMese() {
		return mese;
	}
	public void setMese(int mese) {
		this.mese = mese;
	}
	public String getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}
	public int getGradi() {
		return gradi;
	}
	public void setGradi(int gradi) {
		this.gradi = gradi;
	}

}
