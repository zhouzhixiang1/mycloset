package modello2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Armadio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@OneToMany(mappedBy="armadio", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Componente> componenti;
	
	public void addComponente (Componente c) {
		if (this.componenti == null)
			this.componenti = new ArrayList<>();
		this.componenti.add(c);
		c.setArmadio(this);
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

	public List<Componente> getComponenti() {
		return componenti;
	}

	public void setComponenti(List<Componente> componenti) {
		this.componenti = componenti;
	}
	
	

}
