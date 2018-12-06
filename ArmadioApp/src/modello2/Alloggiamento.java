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
public class Alloggiamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@OneToMany(mappedBy="alloggiamento", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<SpazioVesitito> spaziVestiti;
	
	public void addSpazioVesititi (SpazioVesitito sv) {
		if (this.spaziVestiti == null)
			this.spaziVestiti = new ArrayList<>();
		this.spaziVestiti.add(sv);
		sv.setAlloggiamento(this);
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Componente componente;

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

	public List<SpazioVesitito> getSpaziVestiti() {
		return spaziVestiti;
	}

	public void setSpaziVestiti(List<SpazioVesitito> spaziVestiti) {
		this.spaziVestiti = spaziVestiti;
	}

	public Componente getComponente() {
		return componente;
	}

	public void setComponente(Componente componente) {
		this.componente = componente;
	}
	
	
	
}
