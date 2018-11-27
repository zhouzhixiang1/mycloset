<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.Id;
=======
import java.util.*;
>>>>>>> branch 'master' of https://github.com/zhouzhixiang1/mycloset.git

@Entity
public class Guardaroba {
	
<<<<<<< HEAD
@Id
private int id;
=======
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

>>>>>>> branch 'master' of https://github.com/zhouzhixiang1/mycloset.git
}
