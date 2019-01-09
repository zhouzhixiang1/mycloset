package utility;

import java.util.Random;

import javax.persistence.EntityManager;

import modello2.Outfit;
import modello2.TipoOutfit;
import variabiliApp.Variabili;
import modello2.TipoVestito;
import modello2.Vestito;

public class CreazioneOutfit {
	
	public static void creaOutfit() {
		EntityManager em = EntityManagerProvider.getEntityManager();
		em.getTransaction().begin();
		
		String stagione = TrovaStagione.stagione(Variabili.mese);
		Boolean feriale = Variabili.feriale;
		
		if(feriale) {
			String nome = stagione+"Feriale";
			Outfit o = em.createQuery("select o from Outfit o where o.nome=:nome", Outfit.class).setParameter("nome", nome).getSingleResult();
			for (Outfit os: o.getOutfit()) {
				//AGGIUNGERE CONDIZIONE SCELTA IN BASE A TEMPERATURA
				if (os.getNome().equals("invernale1")) {
					TipoOutfit top = os.getTipoOutfit();
					for(TipoOutfit to: top.getTipiOutfit()) {
						for (TipoVestito tp: to.getTipiVestito()) {
							//AGGIUNGERE CONDIZIONI SCELTA VESTITO (sostituito con Random)
							Random r = new Random();
							int n = r.nextInt(tp.getVestiti().size());
							System.out.println(tp.getVestiti().get(n).getNome());
						}
					}
				}
			}
		}
		
	}

}
