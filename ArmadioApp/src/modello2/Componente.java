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
public class Componente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@OneToMany(mappedBy="componente", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Alloggiamento> alloggiamenti;
	
	public void addAlloggiamento (Alloggiamento a) {
		if (this.alloggiamenti == null)
			this.alloggiamenti = new ArrayList<>();
		this.alloggiamenti.add(a);
		a.setComponente(this);
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Armadio armadio;

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

	public List<Alloggiamento> getAlloggiamenti() {
		return alloggiamenti;
	}

	public void setAlloggiamenti(List<Alloggiamento> alloggiamenti) {
		this.alloggiamenti = alloggiamenti;
	}

	public Armadio getArmadio() {
		return armadio;
	}

	public void setArmadio(Armadio armardio) {
		this.armadio = armardio;
	}
	
	

}
