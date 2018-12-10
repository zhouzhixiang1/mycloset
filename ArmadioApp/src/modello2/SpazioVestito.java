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
public class SpazioVestito {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private TipoVestito tipoVestito;
	private Integer numeroSpazi;
	
	@OneToMany(mappedBy="spazioVestito", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Vestito> vestiti;
	
	public void addVestito (Vestito v) {
		if (this.vestiti == null)
			this.vestiti = new ArrayList<>();
		this.vestiti.add(v);
		v.setSpazioVestito(this);
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Alloggiamento alloggiamento;
	
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
	public Integer getNumeroSpazi() {
		return numeroSpazi;
	}
	public void setNumeroSpazi(Integer numeroSpazi) {
		this.numeroSpazi = numeroSpazi;
	}
	public List<Vestito> getVestiti() {
		return vestiti;
	}
	public void setVestiti(List<Vestito> vestiti) {
		this.vestiti = vestiti;
	}
	public Alloggiamento getAlloggiamento() {
		return alloggiamento;
	}
	public void setAlloggiamento(Alloggiamento alloggiamento) {
		this.alloggiamento = alloggiamento;
	}
	
	
}
