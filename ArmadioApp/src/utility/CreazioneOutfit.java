package utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;

import modello2.Outfit;
import modello2.OutfitFatto;
import modello2.TipoOutfit;
import Variabili.Variabili;
import modello2.TipoVestito;
import modello2.Vestito;

public class CreazioneOutfit {
	
	public static void creaOutfit() {
		EntityManager em = EntityManagerProvider.getEntityManager();
		em.getTransaction().begin();
		
		String stagione = TrovaStagione.stagione(Variabili.mese);
		Boolean feriale = Variabili.feriale;
		int temperatura = Variabili.temperatura;
		
		if(feriale) {
			String nome = stagione+"Feriale";
			Outfit o = em.createQuery("select o from Outfit o where o.nome=:nome", Outfit.class).setParameter("nome", nome).getSingleResult();
			for (Outfit os: o.getOutfit()) { 
				if (temperatura >= os.getTemperatura() & temperatura <= os.getTemperaturaMassima()) {
					List<Vestito> lista_vestiti = new ArrayList<>();
					lista_vestiti.clear();
					boolean disponibili = false;
					System.out.println(os.getOutfitFatti().size());
					for(OutfitFatto of0: os.getOutfitFatti()) {
						System.out.println("Finalmente!");
						boolean disponibile = true;
						for (Vestito vv: of0.getVestitiFatti()) {
							if (vv.isDisponibile() == false) {
								disponibile = false;
								break;
							}
							else
								lista_vestiti.add(vv);
						}
						if(disponibile) {
							disponibili = true;
							break;
						}
					}
					if(disponibili) {
						for (Vestito v: lista_vestiti) {
							System.out.println(v.getNome());
						}
					}
					else {
						System.out.println("Beh direi di si");
						lista_vestiti.clear();
						TipoOutfit top = os.getTipoOutfit();
						OutfitFatto of = new OutfitFatto();
						for(TipoOutfit to: top.getTipiOutfit()) {
							for (TipoVestito tp: to.getTipiVestito()) {
								//AGGIUNGERE CONDIZIONI SCELTA VESTITO
								for(Vestito v: tp.getVestiti()) {
									if (v.isDisponibile()) {
										System.out.println(v.getNome());
										lista_vestiti.add(v);
									}
								}
							}
						}
						of.setVestitiFatti(lista_vestiti);
						of.setOutfitCollegato(os);
						os.addOutfitFatto(of);
						em.persist(os);
						em.persist(of);
						em.getTransaction().commit();
					}
				}
			}
		}
		
	}

}
