package utility;

import java.util.Random;

import modello2.Outfit;
import modello2.TipoOutfit;
import modello2.TipoVestito;
import modello2.Vestito;

public class CreaOutfit {
	
	public static void creaOutfit(Outfit o) {
		TipoOutfit tof = o.getTipoOutfit();
		for(TipoOutfit tos: tof.getTipiOutfit()) {
			for(TipoVestito tvs: tos.getTipiVestito()) {
				Random rand = new Random();
				int n = rand.nextInt(tvs.getVestiti().size());
				Vestito vs = tvs.getVestiti().get(n);
				o.addVestito(vs);
				System.out.println(vs.getNome());
			}
		}
	}

}
