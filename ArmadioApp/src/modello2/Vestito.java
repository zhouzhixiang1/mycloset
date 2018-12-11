package modello2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Vestito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private boolean disponibile;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private TipoVestito tipoVestito;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Outfit> outfit;
		
	@ManyToOne(cascade=CascadeType.ALL)
	private SpazioVestito spazioVestito;
	
	public void addOutfit(Outfit o) {
		if(this.outfit == null)
			outfit = new ArrayList<>();
		this.outfit.add(o);
	}
	
	private String tessuto;

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

	public TipoVestito getTipoVestito() {
		return tipoVestito;
	}

	public void setTipoVestito(TipoVestito tipoVestito) {
		this.tipoVestito = tipoVestito;
	}

	public SpazioVestito getSpazioVestito() {
		return spazioVestito;
	}

	public void setSpazioVestito(SpazioVestito spazioVestito) {
		this.spazioVestito = spazioVestito;
	}

	public String getTessuto() {
		return tessuto;
	}

	public void setTessuto(String tessuto) {
		this.tessuto = tessuto;
	}

	public List<Outfit> getOutfit() {
		return outfit;
	}

	public void setOutfit(List<Outfit> outfit) {
		this.outfit = outfit;
	}

	public boolean isDisponibile() {
		return disponibile;
	}

	public void setDisponibile(boolean disponibile) {
		this.disponibile = disponibile;
	}
}
