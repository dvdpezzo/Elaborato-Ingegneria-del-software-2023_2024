package gestioneAccesso;

import utilitaGenerale.*;

/* MENU DI ACCESSO MOLTO BASILARE, BISOGNA CREARE UNA CLASSE DI GESTIONE DEL FILE DI ACCESO (UNA MAPPA) */

public class MenuAccesso {

    private final String [] AZIONI_POSSIBILI ={"ACCESSO COORDINATORE", "ACCESSO FRUITORE"};

    public void avvio(GestoreAccesso gestoreAccesso) {
        int scelta=0;
        MenuUtil menuLogin = new MenuUtil("MENU DI ACCESSO:", AZIONI_POSSIBILI);
        do {
            scelta = menuLogin.scegli();
            switch(scelta){
                case 1 -> {
                    String passConfig;
                    String nomeConfig;
                    do {
                        nomeConfig= InputDati.leggiStringaNonVuota("Inserire nome utente: ");
                        passConfig= InputDati.leggiStringaNonVuota("Inserisci password: ");
                        //da sistemare il controllo sul primo accesso
                    } while (gestoreAccesso.primoAccesso(nomeConfig, passConfig));
                    gestoreAccesso.accessoUtente(nomeConfig, passConfig); //->ritorna un booleano che indica se l'accesso è riuscito
                    //da implementare cosa l'accesso farà
                }
                case 2 -> {
                    String passFruitore;
                    String nomeFruitore;
                    do {
                        nomeFruitore= InputDati.leggiStringaNonVuota("Inserire nome utente: ");
                        passFruitore= InputDati.leggiStringaNonVuota("Inserisci password: ");
                    } while (gestoreAccesso.primoAccesso(nomeFruitore, passFruitore));
                    gestoreAccesso.accessoUtente(nomeFruitore, passFruitore);
                }
            }
            //accesso coordinatore
            //accesso fruitore
                    }while(scelta!=0);
    }
}
