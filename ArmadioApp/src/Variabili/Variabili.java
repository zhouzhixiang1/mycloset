package Variabili;

import utility.TrovaStagione;

public class Variabili {
	
	public static boolean feriale = true;
	public static int mese = 12;
	public static Integer temperatura = 0;

	
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
	public Integer getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Integer temperatura) {
		this.temperatura = temperatura;
	}

}
