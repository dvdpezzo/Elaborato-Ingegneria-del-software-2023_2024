package model;

import gestioneAccesso.MenuAccesso;
import java.util.List;
import utilitaGenerale.MenuUtil;

public class Main {
	public static void main(String[] args) {
		
		//mostra menu d'accesso
		Configuratore configuratore = (Configuratore) MenuAccesso.avvioLogin();
		boolean isLoggedIn = true;
		String[] vociMenuBackEnd = new String[]{"AGGIUNGI COMPRENSORIO", 
												"AGGIUNGI NUOVA GERARCHIA",
												"AGGIUNGI CATEGORIA A GERARCHIA ESISTENTE",
												"VISUALIZZA",
												"SALVA",
												"LOGOUT"};
      
        //se credenziali validi, mostra menu back-end:
		MenuUtil menuBackEnd = new MenuUtil("MENU BACK-END:", vociMenuBackEnd);
		do {
			int scelta = menuBackEnd.scegli();

			switch (scelta) {
				case 1 -> {
								ComprensorioGeografico comprensorio = configuratore.creaComprensorioGeografico();
								System.out.println("Comprensorio aggiunto.");
					}
				case 2 -> {
								List<Categoria> gerarchia = configuratore.creaGerarchia();
								System.out.println("Nuova gerarchia creata.");
					}
				case 3 -> {
								Categoria categoria = configuratore.creaCategoria();
								System.out.println("Categoria aggiunta a gerarchia esistente.");
					}
				case 4 -> {
								String[] vociMenuVisualizzazione = new String[]{"COMPRENSORI", "GERARCHIA", "FATTIori DI CONVERSIONE"};
								MenuUtil menuVisualizza = new MenuUtil("MENU DI VISUALIZZAZIONE:", vociMenuVisualizzazione);
								
								int sceltaVisualizza = menuVisualizza.scegli();
								switch (sceltaVisualizza) {
									case 1 -> configuratore.visualizzaComprensori();
									case 2 -> configuratore.visualizzaGerarchia();
									case 3 -> configuratore.visualizzaFattoriConversione();
								}
					}
				case 5 -> {
								configuratore.salvaCambiamenti();
								System.out.println("Cambiamenti salvati.");
					}
				case 0 -> {
								isLoggedIn = false;
								System.out.println("Logout effettuato.");
					}
			}		
		} while (isLoggedIn);
	}
}

/* Bisgona modificare il Main ed il  Menu in modo che permetta di inserire più comuni nella lista dei comuni da sceglire, magari 
 * prima di creare il compensorio si può chiedere se si vogliono inserire dei comuni con la scelta YES OR NO di InputDati.
 */