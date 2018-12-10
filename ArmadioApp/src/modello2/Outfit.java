package modello2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Outfit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	private TipoOutfit tipoOutfit;
	
	@OneToMany(mappedBy="outfitPrincipale", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Outfit> outfit;
	
	public void addOutfit (Outfit o) {
		if (this.outfit == null)
			this.outfit = new ArrayList<>();
		this.outfit.add(o);
		o.setOutfitPrincipale(this);
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Outfit outfitPrincipale;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoOutfit getTipoOutfit() {
		return tipoOutfit;
	}
	public void setTipoOutfit(TipoOutfit tipoOutfit) {
		this.tipoOutfit = tipoOutfit;
	}
	public List<Outfit> getOutfit() {
		return outfit;
	}
	public void setOutfit(List<Outfit> outfit) {
		this.outfit = outfit;
	}
	public Outfit getOutfitPrincipale() {
		return outfitPrincipale;
	}
	public void setOutfitPrincipale(Outfit outfitPrincipale) {
		this.outfitPrincipale = outfitPrincipale;
	}
	
	

}
