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
	private boolean feriale;
	private boolean outdoor;
	private Integer temperatura;
	private Integer temperaturaMassima;
	
	@OneToMany(mappedBy="outfitPrincipale", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Outfit> outfit;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Outfit outfitPrincipale;
	
	@OneToMany(mappedBy="outfitCollegato", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<OutfitFatto> outfitFatti;
	
	public void addOutfitFatto(OutfitFatto of) {
		if(this.outfitFatti == null)
			this.outfitFatti = new ArrayList<>();
		this.outfitFatti.add(of);
		of.setOutfitCollegato(this);
	}
	
	public void addOutfit (Outfit o) {
		if (this.outfit == null)
			this.outfit = new ArrayList<>();
		this.outfit.add(o);
		o.setOutfitPrincipale(this);
	}
		
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

	public boolean isFeriale() {
		return feriale;
	}

	public void setFeriale(boolean feriale) {
		this.feriale = feriale;
	}

	public boolean isOutdoor() {
		return outdoor;
	}

	public void setOutdoor(boolean outdoor) {
		this.outdoor = outdoor;
	}

	public Integer getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Integer temperatura) {
		this.temperatura = temperatura;
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

	public Integer getTemperaturaMassima() {
		return temperaturaMassima;
	}

	public void setTemperaturaMassima(Integer temperaturaMassima) {
		this.temperaturaMassima = temperaturaMassima;
	}

	public List<OutfitFatto> getOutfitFatti() {
		return outfitFatti;
	}

	public void setOutfitFatti(List<OutfitFatto> outfitFatti) {
		this.outfitFatti = outfitFatti;
	}
}
