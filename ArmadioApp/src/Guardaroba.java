import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.*;

@Entity
public class Guardaroba {
	
@Id
private int id;
	private List<Vestito> vestiti;
    
	private Outfit outfit;

	public List<Vestito> getVestiti() {
		return vestiti;
	}

	public void setVestiti(List<Vestito> vestiti) {
		this.vestiti = vestiti;
	}

	public Outfit getOutfit() {
		return outfit;
	}

	public void setOutfit(Outfit outfit) {
		this.outfit = outfit;
	}

}
