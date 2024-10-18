package MenuBackEnd;

import java.util.List;
import utilitaGenerale.*;
import model.*;

public class menuBackEnd {

    Configuratore configuratore = new Configuratore(null, null);
    GestoreComuni gc = new GestoreComuni();

    String[] vociMenuBackEnd = new String[]{"AGGIUNGI COMUNE","AGGIUNGI COMPRENSORIO", 
												"AGGIUNGI NUOVA GERARCHIA",
												"AGGIUNGI CATEGORIA A GERARCHIA ESISTENTE",
												"VISUALIZZA",
												"SALVA",
												"LOGOUT"};
      
	
        //se credenziali validi, mostra menu back-end:
		MenuUtil menuBackEnd = new MenuUtil("MENU BACK-END:", vociMenuBackEnd);

        {
		boolean isLoggedIn = true;
		do {
			int scelta = menuBackEnd.scegli();
            switch (scelta) {  
            
                case 1 -> {     
                            boolean prova=true;
                            do{
                                if(InputDati.yesOrNo("Vuoi aggiungere un comune?")){
                                      String nome = InputDati.leggiStringa("Inserisci il nome del comune:");
                                      Comuni comune = new Comuni(nome);
                                      gc.aggiungiComune(comune);
                                      prova=true;
                                }   
                                else prova=false;     
                            }while(prova);
                    }
				case 2 -> {
								ComprensorioGeografico comprensorio = configuratore.creaComprensorioGeografico();
								System.out.println("Comprensorio aggiunto.");
					}
				case 3 -> {
							    List<Categoria> gerarchia = configuratore.creaGerarchia();
								System.out.println("Nuova gerarchia creata.");
					}
				case 4 -> {
								Categoria categoria = configuratore.creaCategoria();
								System.out.println("Categoria aggiunta a gerarchia esistente.");
					}
				case 5 -> {
								String[] vociMenuVisualizzazione = new String[]{"COMPRENSORI", "GERARCHIA", "FATTIori DI CONVERSIONE"};
								MenuUtil menuVisualizza = new MenuUtil("MENU DI VISUALIZZAZIONE:", vociMenuVisualizzazione);
								
								int sceltaVisualizza = menuVisualizza.scegli();
								switch (sceltaVisualizza) {
									case 1 -> configuratore.visualizzaComprensori();
									case 2 -> configuratore.visualizzaGerarchia();
									case 3 -> configuratore.visualizzaFattoriConversione();
								}
					}
				case 6 -> {
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

	//da sistemare e implementare nel main