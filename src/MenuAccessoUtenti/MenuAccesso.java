package menuAccessoUtenti;

import utilitaGenerale.*;

/* MENU DI ACCESSO MOLTO BASILARE, BISOGNA CREARE UNA CLASSE DI GESTIONE DEL FILE DI ACCESO (UNA MAPPA) */

public class MenuAccesso {

    private final String [] AZIONI_POSSIBILI ={"ACCESSO COORDINATORE", "ACCESSO FRUITORE"};

    public void avvio() {
        int valore=0;
        MenuUtil menuLogin = new MenuUtil("MENU DI ACCESSO:", AZIONI_POSSIBILI);
        GestoreAccesso gestoreAccesso = new GestoreAccesso();
        do {
            valore=menuLogin.scegli();
            switch(valore){
                //accesso coordinatore
                case 1:
                    System.out.println("Non ancora implementato");
                    break;
                //accesso fruitore
                case 2:
                    System.out.println("Non ancora implementato");
                    break;
            }

        }while(valore!=0);
    }
}
