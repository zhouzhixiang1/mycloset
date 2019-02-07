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
							System.out.println(v.getNome()+" - colore: "+v.getColore());
						}
					}
					else {
						System.out.println("Beh direi di si");
						lista_vestiti.clear();
						TipoOutfit top = os.getTipoOutfit();
						OutfitFatto of = new OutfitFatto();
						/*Da qui in poi i tipi di outfit (es: intimo, sopra, sotto) verranno ciclati per trovare la lista dei vestiti corrispondente
						  ad ogni tipo. Al momento il codice qua sotto permette di abbinare i vestiti in base al colore, evitando ripetizioni di colori uguali nell'abbinamento
						  per pantaloni e camicia. Risulta essere lungo perché ho tenuto conto delle varie ripetizioni che il programma deve eseguire nel caso non trovi un vestito
						  di un determinato colore, in modo che rinizi un nuovo ciclo da un nuovo punto di partenza e quindi partendo da un vestito che abbia un colore diverso dal precedente.
						  LEGGERE LE NOTE NELLA CLASSE: "AbbinaColori" PER ULTERIORI DETTAGLI ESPLICATIVI*/
						for(TipoOutfit to: top.getTipiOutfit()) {
							// INTIMO - SOPRA
							ArrayList<Vestito> lista_fatti = new ArrayList<Vestito>();
							ArrayList<String> colori = new ArrayList<String>();
							int conta = 0;
							boolean err = false;
							boolean fatto = false;
							int i = 0;
							int x = 0;
							int a = 0;
							int b = 0;
							int indErr = -1;
							
							while(fatto == false) {
								for(a=0; a<to.getTipiVestito().size(); a++) {
									TipoVestito tv = to.getTipiVestito().get(a);
									if(a == indErr) {
										b++;
										x = b;
									}
									else
										x=0;
									System.out.println(x);
									for(i=0+x; i<tv.getVestiti().size(); i++) {
										Vestito v = tv.getVestiti().get(i);
										colori.add(v.getColore());
										if(v.isDisponibile() && new AbbinaColori(colori, to.getNome()).combina()) {
											err = false;
											System.out.println(v.getNome());
											lista_fatti.add(v);
											conta++;
											break;
										}
										else if(i == tv.getVestiti().size()-1 && a == to.getTipiVestito().size()-1 && err){
											System.out.println(v.getNome());
											lista_fatti.add(v);
											conta++;
											break;
										}
										else {
											colori.remove(colori.size()-1);
										}
									}
								}
								if(conta == to.getTipiVestito().size()) {
									fatto = true;
									lista_vestiti.addAll(lista_fatti);
									a = 0;
								}
								else {
									err = true;
									indErr = 0;
									colori.clear();
									lista_fatti.clear();
									conta--;
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
					break;
				}
			}
		}
	}
}
