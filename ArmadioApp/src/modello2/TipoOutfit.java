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
import javax.persistence.OneToMany;

@Entity
public class TipoOutfit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@ManyToMany(mappedBy="tipoOutfitPrincipale", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<TipoOutfit> tipiOutfit;
	
	@ManyToMany(mappedBy="tipiOutfit", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<TipoVestito> tipiVestito;
	
	public void addTipoOutfit (TipoOutfit to) {
		if (this.tipiOutfit == null)
			this.tipiOutfit = new ArrayList<>();
		this.tipiOutfit.add(to);
		to.getTipoOutfitPrincipale().add(this);
	}
	
	public void addTipoVestito (TipoVestito tv) {
		if (this.tipiVestito == null)
			this.tipiVestito = new ArrayList<>();
		this.tipiVestito.add(tv);
		tv.addTipoOutfit(this);
	}
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<TipoOutfit> tipoOutfitPrincipale;
	
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
	public List<TipoOutfit> getTipiOutfit() {
		return tipiOutfit;
	}
	public void setTipiOutfit(List<TipoOutfit> tipiOutfit) {
		this.tipiOutfit = tipiOutfit;
	}
	public List<TipoVestito> getTipiVestito() {
		return tipiVestito;
	}
	public void setTipiVestito(List<TipoVestito> tipiVestito) {
		this.tipiVestito = tipiVestito;
	}

	public List<TipoOutfit> getTipoOutfitPrincipale() {
		return tipoOutfitPrincipale;
	}

	public void setTipoOutfitPrincipale(List<TipoOutfit> tipoOutfitPrincipale) {
		this.tipoOutfitPrincipale = tipoOutfitPrincipale;
	}
	
	
}
