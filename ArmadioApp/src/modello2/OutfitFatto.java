package modello2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class OutfitFatto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Outfit outfitCollegato;
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Vestito> vestitiFatti;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Outfit getOutfitCollegato() {
		return outfitCollegato;
	}

	public void setOutfitCollegato(Outfit outfitCollegato) {
		this.outfitCollegato = outfitCollegato;
	}

	public List<Vestito> getVestitiFatti() {
		return vestitiFatti;
	}

	public void setVestitiFatti(List<Vestito> vestitiFatti) {
		this.vestitiFatti = vestitiFatti;
	}
	

}
