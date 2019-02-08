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
						
						ArrayList<ArrayList<Vestito>> abbinati = new ArrayList<ArrayList<Vestito>>();
						ArrayList<ArrayList<Vestito>> disponibil = new ArrayList<ArrayList<Vestito>>();
						ArrayList<ArrayList<Vestito>> ripiego = new ArrayList<ArrayList<Vestito>>();
						

						for(TipoOutfit to: top.getTipiOutfit()) {
							
							ArrayList<Vestito> parteSopra = new ArrayList<Vestito>();
							ArrayList<Vestito> parteSotto = new ArrayList<Vestito>();	
							
							int i = 0;
							for(TipoVestito tv: to.getTipiVestito()) {
								for(Vestito v: tv.getVestiti()) {
									if(i==0)
										parteSopra.add(v);
									else
										parteSotto.add(v);
								}
								i++;
							}
							
							for(Vestito v: parteSopra) {
								for(Vestito v2: parteSotto) {
									ArrayList<String> colori = new ArrayList<String>();
									ArrayList<Vestito> selezionati = new ArrayList<Vestito>();
									selezionati.add(v);
									selezionati.add(v2);
									colori.add(v.getColore());
									colori.add(v2.getColore());
									if(v.isDisponibile()) {
										
										if(v2.isDisponibile()) {
											
											if(new AbbinaColori(colori, to.getNome()).combina()) {
												abbinati.add(selezionati);
											}
											else
												disponibil.add(selezionati);
										}
										else if(v2.isDisponibile()==false && new AbbinaColori(colori, to.getNome()).combina())
											ripiego.add(selezionati);
									}
								}
							}
						}
						
						boolean abb = false;
						boolean disp = false;
						boolean ripie = false;
						
						if(abbinati.size()>0)
							abb=true;
						else if(disponibil.size()>0)
							disp=true;
						else ripie=true;
						
						if(abb) {
							Random r = new Random();
							int i = r.nextInt(abbinati.size());
							lista_vestiti.addAll(abbinati.get(i));
						}
						
						if(disp) {
							Random r = new Random();
							int i = r.nextInt(disponibil.size());
							lista_vestiti.addAll(disponibil.get(i));
						}
						
						if(ripie) {
							Random r = new Random();
							int i = r.nextInt(ripiego.size());
							lista_vestiti.addAll(ripiego.get(i));
						}
						
						System.out.println("Outfit abbinati: ");
						for(ArrayList<Vestito> av: abbinati) {
							for(Vestito v: av) {
								System.out.println(v.getNome()+" - colore: "+v.getColore());
							}
							System.out.println();
						}
						
						System.out.println("Outfit disponibili: ");
						for(ArrayList<Vestito> av: disponibil) {
							for(Vestito v: av)
								System.out.println(v.getNome()+" - colore: "+v.getColore());
							System.out.println();
						}
						
						System.out.println("Outfit ripiego: ");
						for(ArrayList<Vestito> av: ripiego) {
							for(Vestito v: av)
								System.out.println(v.getNome()+" - colore: "+v.getColore());
							System.out.println();
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
