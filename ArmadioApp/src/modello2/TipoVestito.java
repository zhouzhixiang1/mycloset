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
import javax.persistence.OneToMany;

@Entity
public class TipoVestito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<TipoOutfit> tipiOutfit;
	
	@OneToMany(mappedBy="tipoVestito", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Vestito> vestiti;
	
	public void addVestito (Vestito v) {
		if (this.vestiti == null)
			this.vestiti = new ArrayList<>();
		this.vestiti.add(v);
		v.setTipoVestito(this);
	}
	
	public void addTipoOutfit (TipoOutfit to) {
		if (this.tipiOutfit == null)
			this.tipiOutfit = new ArrayList<>();
		this.tipiOutfit.add(to);
		//to.addTipoVestito(this);
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

	public List<Vestito> getVestiti() {
		return vestiti;
	}

	public void setVestiti(List<Vestito> vestiti) {
		this.vestiti = vestiti;
	}

	public List<TipoOutfit> getTipiOutfit() {
		return tipiOutfit;
	}

	public void setTipiOutfit(List<TipoOutfit> tipiOutfit) {
		this.tipiOutfit = tipiOutfit;
	}
	
	
	

}
