package utility;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;

import modello2.Outfit;
import modello2.TipoOutfit;
import modello2.TipoVestito;
import modello2.Vestito;
import variabiliApp.Variabili;

public class CreaOutfit {
	
	public static void creaOutfit(Outfit o) {
		for(Outfit os: o.getOutfit()) {
			if(os.getNome().equals("invernale1")) {
				TipoOutfit tof = os.getTipoOutfit();
				for(TipoOutfit tos: tof.getTipiOutfit()) {
					for(TipoVestito tvs: tos.getTipiVestito()) {
						Random rand = new Random();
						int n = rand.nextInt(tvs.getVestiti().size());
						Vestito vs = tvs.getVestiti().get(n);
						os.addVestito(vs);
						System.out.println(vs.getNome());
					}
				}
			}
		}
	}
	
	public static void creaOutfitSerio() {
		
		if(TrovaStagione.stagione(Variabili.mese).equals("inverno")) {
			if(Variabili.feriale)
				creaOutfitInvernaleFeriale();
			else
				creaOutfitInvernaleFestivo();
		}
		
		else if(TrovaStagione.stagione(Variabili.mese).equals("primavera")){
			if(Variabili.feriale)
				creaOutfitPrimaverileFeriale();
			else
				creaOutfitPrimaverileFestivo();
			
		}
		
		else if(TrovaStagione.stagione(Variabili.mese).equals("estate")){
			if(Variabili.feriale)
				creaOutfitEstivoFeriale();
			else
				creaOutfitEstivoFestivo();	
		}
		
		else if(TrovaStagione.stagione(Variabili.mese).equals("autunno")){
			if(Variabili.feriale)
				creaOutfitAutunnaleFeriale();
			else
				creaOutfitAutunnaleFestivo();
			
		}
	}

	private static void creaOutfitAutunnaleFestivo() {
		// TODO Auto-generated method stub
		
	}

	private static void creaOutfitAutunnaleFeriale() {
		
		
	}

	private static void creaOutfitEstivoFestivo() {
		// TODO Auto-generated method stub
		
	}

	private static void creaOutfitEstivoFeriale() {
		// TODO Auto-generated method stub
		
	}

	private static void creaOutfitPrimaverileFestivo() {
		// TODO Auto-generated method stub
		
	}

	private static void creaOutfitPrimaverileFeriale() {
		// TODO Auto-generated method stub
		
	}

	private static void creaOutfitInvernaleFestivo() {
		// TODO Auto-generated method stub
		
	}

	private static void creaOutfitInvernaleFeriale() {
		EntityManager em = EntityManagerProvider.getEntityManager();
		
		Outfit o = em.createQuery("select o from Outfit o where o.outfit.nome=:'InvernaleFeriale'", Outfit.class).getSingleResult();
		em.getTransaction().begin();
		creaOutfit(o);
		em.getTransaction().commit();

	}

}
