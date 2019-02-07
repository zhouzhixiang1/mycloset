package utility;

import java.util.ArrayList;

public class AbbinaColori {
	
	private ArrayList<String> colori;
	private String nome;
	private String[] coloriCaldi = {"rosso","arancione","giallo", "rosso", "magenta", "magenta", "rosa", "marrone", "jeans", "grigio"};
	private String[] coloriFreddi = {"verde chiaro", "verde", "blu", "azzurro", "jeans", "viola", "fucsia", "grigio"};
	
	//il parametro nome si riferisce al nome di tipo di outfit
	public AbbinaColori(ArrayList<String> colori, String nome) {
		this.colori = colori;
		this.nome = nome;
	}
	
	//se l'outfit è di tipo "sopra" (es: camicia e jeans) non potranno essere abbinati due vestiti di colori uguali
	public boolean combina() {
		if(colori.size() == 1)
			return true;
		else if(abbina(colori.get(0),(colori.get(1)))==false && nome.equals("Sopra")) {
			return false;
		}
		
		else if(nome.equals("Intimo") && colori.get(colori.size()-2).equals(colori.get(colori.size()-1))==false) {
			return false;
		}
		return true;
	}
	
	private boolean abbina(String col1, String col2) {
		if(col1.equals(col2))
			return false;
		else if((isCaldo(col1) && isCaldo(col2)) || (isFreddo(col2) && isFreddo(col1))) {
			return true;
			}
		else
			return false;
	}
	
	private boolean isCaldo(String col){
		for(String colr: this.coloriCaldi) {
			if (colr.equals(col))
				return true;
		}
		return false;
	}
	
	private boolean isFreddo(String col){
		for(String colr: this.coloriFreddi) {
			if (colr.equals(col))
				return true;
		}
		return false;
	}

}
