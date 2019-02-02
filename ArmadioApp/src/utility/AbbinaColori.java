package utility;

import java.util.ArrayList;

public class AbbinaColori {
	
	private ArrayList<String> colori;
	private String nome;
	
	public AbbinaColori(ArrayList<String> colori, String nome) {
		this.colori = colori;
		this.nome = nome;
	}
	
	public boolean combina() {
		if(colori.size() == 1)
			return true;
		else if(colori.get(0).equals(colori.get(1)))
			return false;
		return true;
	}

}
