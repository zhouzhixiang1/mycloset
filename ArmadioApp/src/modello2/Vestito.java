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
public class Vestito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private boolean disponibile;
	
	@ManyToMany(mappedBy="vestitiFatti", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<OutfitFatto> outfitCollegati;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private TipoVestito tipoVestito;
		
	@ManyToOne(cascade=CascadeType.ALL)
	private SpazioVestito spazioVestito;
	
	private String tessuto;
	
	private String colore;

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


	public boolean isDisponibile() {
		return disponibile;
	}

	public void setDisponibile(boolean disponibile) {
		this.disponibile = disponibile;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}
}
