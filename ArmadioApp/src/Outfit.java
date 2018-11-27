import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Outfit {
	@Id
	private int id;
	
	Vestito testa,parteSopra,parteSotto,piedi;
	@OneToMany(mappedBy="outfit")
	List<Vestito> vestitiOutfit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vestito getTesta() {
		return testa;
	}

	public void setTesta(Vestito testa) {
		this.testa = testa;
	}

	public Vestito getParteSopra() {
		return parteSopra;
	}

	public void setParteSopra(Vestito parteSopra) {
		this.parteSopra = parteSopra;
	}

	public Vestito getParteSotto() {
		return parteSotto;
	}

	public void setParteSotto(Vestito parteSotto) {
		this.parteSotto = parteSotto;
	}

	public Vestito getPiedi() {
		return piedi;
	}

	public void setPiedi(Vestito piedi) {
		this.piedi = piedi;
	}

	public List<Vestito> getVestitiOutfit() {
		return vestitiOutfit;
	}

	public void setVestitiOutfit(List<Vestito> vestitiOutfit) {
		this.vestitiOutfit = vestitiOutfit;
	} 
}
