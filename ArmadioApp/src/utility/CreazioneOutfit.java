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
						/*Da qui in poi i tipi di outfit (es: intimo, sopra, sotto) verranno ciclati per trovare la lista dei vestiti corrispondente
						  ad ogni tipo. Al momento il codice qua sotto permette di abbinare i vestiti in base al colore, evitando ripetizioni di colori uguali nell'abbinamento
						  per pantaloni e camicia. Risulta essere lungo perché ho tenuto conto delle varie ripetizioni che il programma deve eseguire nel caso non trovi un vestito
						  di un determinato colore, in modo che rinizi un nuovo ciclo da un nuovo punto di partenza e quindi partendo da un vestito che abbia un colore diverso dal precedente.
						  LEGGERE LE NOTE NELLA CLASSE: "AbbinaColori" PER ULTERIORI DETTAGLI ESPLICATIVI*/
						for(TipoOutfit to: top.getTipiOutfit()) {
							//La classe "AbbinaColori" si occuperà di trovare un abbinamento mano a mano che i colori verranno aggiunti all'arraylist colori. Da notare che il primo colore
							//aggiunto alla lista verrà sempre accettato dal programma al momento. (Ecco il perché della ripetizione del ciclo definita dal ciclo while poco più sotto
							
							// quando l'intero "conta" sarà uguale al numero dei vestiti necessari per completare un determinato tipo di outfit, permetterà di interrompere il ciclo while
							// verrà azzerato in caso di fallimento durante l'abbinamento colori
							int conta = 0;
							ArrayList<String> colori = new ArrayList<>();
							ArrayList<Vestito> lista_tipo = new ArrayList<Vestito>(); //lista momentanea per i vestiti
							// l'intero "i" è l'indice che determinerà da dove far partire il ciclo per la ricerca dei vestiti di un determinato tipo da cui verrà estratto il primo colore della lista
							int i = 0;
							// il boolean "ocazz" è una variabile che si attiverà in caso di fallito abbinamento, e sarà quindi l'input che permetterà l'incremento di un nuovo ciclo fino a che l'abbinamento avrà successo.
							boolean ocazz = false;
							boolean fatto = false;
							
							//inizio ciclo
							while(fatto == false) {
								for (TipoVestito tp: to.getTipiVestito()) {
									String nomeV = to.getNome();
									for(int x=0+i; x<tp.getVestiti().size(); x++) {
										Vestito v = tp.getVestiti().get(x);
										colori.add(v.getColore());
										if(ocazz)
											conta = 0;
										if (v.isDisponibile() && new AbbinaColori(colori, nomeV).combina()) { //tutte le condizioni permettono di selezionare un vestito piuttosto che un altro (al momento 2)
											System.out.println(v.getNome());
											lista_tipo.add(v);
											conta++;
											if(ocazz) { //reset parametri
												ocazz = false;
												i=0;
											}
											break;
										}
										else if(v.isDisponibile()==false)
											colori.remove(v.getColore());
										else {
											colori.remove(v.getColore());
											ocazz = true;
											i++;
										}
									}
								}
								if (conta == to.getTipiVestito().size()) {
									lista_vestiti.addAll(lista_tipo); // la lista momentanea viene integrata con quella definitiva in caso di successo
									fatto = true; //permette di uscire dal ciclo while e passare al tipo di outfit successivo
								}
								else {
									lista_tipo.clear(); //reset parametri
									colori.clear();
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
