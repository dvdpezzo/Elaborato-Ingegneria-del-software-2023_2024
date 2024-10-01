package model;

import java.io.IOException;

import menuAccessoUtenti.GestoreAccesso;
import menuAccessoUtenti.GestoreFileAccesso;
import menuAccessoUtenti.MenuAccesso;

public class Test {
    public static void main(String[] args) {
        

		//test di avvio del menu 
		MenuAccesso menu1 = new MenuAccesso();
		//menu1.avvio();
		GestoreAccesso gestoreAccesso = new GestoreAccesso();
		
        gestoreAccesso.aggiungiDatiAllaMappa("utente", "utente");
		
		


    }
    
}
