package model;

import gestioneAccesso.MenuAccesso;
import java.util.List;
import utilitaGenerale.MenuUtil;

public class Main {
	public static void main(String[] args) {
		
		//mostra menu d'accesso
		Configuratore configuratore = (Configuratore) MenuAccesso.avvioLogin();
		boolean isLoggedIn=true;
		
		/* se l'utente è loggato faccio partire il menubackend
		 * se l'utente non è loggato non succede nulla. 
		 * DOMANDA: come collego la condizione isLoggedIn all'avvio del menubackend? (uso if, ma come posso ottenere la certezza che sia loggato?)
		 */
		



		
	}

}