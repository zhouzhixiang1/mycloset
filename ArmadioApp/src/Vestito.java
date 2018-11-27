import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vestito {
	@Id
	private int idVestito;
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
	private Guardaroba guardaroba;
	private Outfit outfit;
}
