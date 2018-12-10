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

@Entity
public class Outfit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@ManyToMany(mappedBy="outfit", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Vestito> vestiti;
		
	private TipoOutfit tipoOutfit;
	
	public void addVestito(Vestito v) {
		if(this.vestiti == null)
			vestiti = new ArrayList<>();
		this.vestiti.add(v);
		v.addOutfit(this);
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
	public List<Vestito> getVestiti() {
		return vestiti;
	}
	public void setVestit(List<Vestito> vestiti) {
		this.vestiti = vestiti;
	}
}
