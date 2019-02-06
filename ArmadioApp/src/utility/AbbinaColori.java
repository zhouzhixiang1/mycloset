package utility;

import java.util.ArrayList;

public class AbbinaColori {
	
	private ArrayList<String> colori;
	private String nome;
	
	//il parametro nome si riferisce al nome di tipo di outfit
	public AbbinaColori(ArrayList<String> colori, String nome) {
		this.colori = colori;
		this.nome = nome;
	}
	
	//se l'outfit è di tipo "sopra" (es: camicia e jeans) non potranno essere abbinati due vestiti di colori uguali
	public boolean combina() {
		if(colori.size() == 1)
			return true;
		else if(colori.get(0).equals(colori.get(1)) && nome.equals("Sopra"))
			return false;
		
		else if(nome.equals("Intimo") && colori.get(colori.size()-2).equals(colori.get(colori.size()-1))==false)
			return false;
		
		return true;
	}

}
