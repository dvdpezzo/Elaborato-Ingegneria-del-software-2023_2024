package gestioneAccesso;
import model.Utente;
import utilitaGenerale.*;

public class MenuAccesso {

    public static Utente avvioLogin(){
        GestoreAccesso gestoreAccesso = new GestoreAccesso();
        Utente result;
        do {
            String nomeUtente= InputDati.leggiStringaNonVuota("Inserire nome utente: ");
            String passUtente= InputDati.leggiStringaNonVuota("Inserisci password: ");
            result = gestoreAccesso.accessoUtente(nomeUtente, passUtente);
        } while (result == null);
        return result;
    }
}
