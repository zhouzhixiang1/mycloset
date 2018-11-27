import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vestito {
	@Id
	private int idVestito;
	@ManyToOne
	private Outfit outfit;
	@ManyToOne
	private Guardaroba guardaroba;
	public int getIdVestito() {
		return idVestito;
	}
	public void setIdVestito(int idVestito) {
		this.idVestito = idVestito;
	}
	public Guardaroba getGuardaroba() {
		return guardaroba;
	}
	public void setGuardaroba(Guardaroba guardaroba) {
		this.guardaroba = guardaroba;
	}
	public Outfit getOutfit() {
		return outfit;
	}
	public void setOutfit(Outfit outfit) {
		this.outfit = outfit;
	}
}
