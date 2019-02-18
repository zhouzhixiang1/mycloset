package modello;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Guardaroba {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToMany(mappedBy = "guardaroba")
	private List<Vestito> vestiti;
	@ManyToOne
	private Outfit outfit;
	@OneToOne
	private Utente utente;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public List<Vestito> getVestiti() {
		return vestiti;
	}

	public void setVestiti(List<Vestito> vestiti) {
		this.vestiti = vestiti;
	}

	public Outfit getOutfit() {
		return outfit;
	}

	public void setOutfit(Outfit outfit) {
		this.outfit = outfit;
	}

}