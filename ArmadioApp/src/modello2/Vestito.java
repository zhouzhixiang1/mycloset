package modello2;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vestito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private TipoVestito tipoVestito;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private SpazioVestito spazioVestito;
	
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
	
	

}
