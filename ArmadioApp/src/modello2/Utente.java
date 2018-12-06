package modello2;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Utente {
	
	@Id
	private String email;
	private String password;
	private boolean attivo;
	@OneToOne (cascade=CascadeType.ALL)
	private Guardaroba guardaroba;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Guardaroba getGuardaroba() {
		return guardaroba;
	}
	public void setGuardaroba(Guardaroba guardaroba) {
		this.guardaroba = guardaroba;
	}
	public boolean getAttivo() {
		return attivo;
	}
	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}
	
	
	
}
