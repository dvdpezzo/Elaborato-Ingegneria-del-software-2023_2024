package menuAccessoUtenti;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;


/**
 * Classe che si occupa solo della gestione della mappa delle credenziali
 */
public class GestoreAccesso {

    private final static String UTENTE_DEFAULT="Utente000";
    private final static String PASS_DEFAULT="Pass000";
    private final static File file_configuratori = new File("File di accesso\\credenzialiConfiguratori.txt");
    //private final static File file_fruitori = new File("File di accesso\\credenzialiFruitori.txt");

    private HashMap<String, String> mappaUtenti;
    private GestoreFileAccesso gestoreFile;
    

    public GestoreAccesso() {
        this.mappaUtenti = new HashMap<>();
        this.gestoreFile = new GestoreFileAccesso(mappaUtenti);
    }

     /**
     * Controlla se si sta facendo il primo accesso analizzando i dati inseriti se sono quelli di default
     * @param nomeUtente
     * @param pass password
     * @return vero se si sta effettuando il primo accesso, falso altrimenti
     */
    private boolean primoAccesso(String nomeUtente, String pass){
        if(nomeUtente.equals(UTENTE_DEFAULT) && pass.equals(PASS_DEFAULT)){
            return true;
        }
        return false;
    }
    /**
     * permette l'accesso al configuratore
     * @param nomeUtente
     * @param pass password
     */
    public void accessoConfig(String nomeUtente, String pass){
        if(primoAccesso(nomeUtente,pass)){
            System.out.println("Sei stasto reindirizzato alla creazione del tuo Nome utente e Password personali:");
        }
        else{
            if(ctrlAccesso(nomeUtente,pass)){
                System.out.println("Accesso effettuato corretamente!");
            }
            else{
                System.out.println("ERRORE! Nome Utente o password errati!");
            }

        }

    }

    /**
     * permette l'accesso al fruitore
     * @param nomeUtente
     * @param pass password
     */
    public void accessoFruit(String nomeUtente, String pass){

    }
    /**
     * Permette di aggiungere nome utente e password nella mappa e le salva sul file
     * @param nomeUtente 
     * @param pass password
     * @throws IOException 
     */
    public void aggiungiDatiAllaMappa(String nomeUtente, String pass) {
        mappaUtenti.put(nomeUtente, pass);
        try {
            gestoreFile.salvaMappaSuFile(file_configuratori);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Controllo sull'unicità del nome utente
     * @param nomeUtente
     * @return se il nome utente non è presente ritorna true
     */
    private boolean controlloCredenzialiNomeUtente(String nomeUtente){
        if(mappaUtenti.containsKey(nomeUtente))
        {
            System.out.println("Nome utente già utilizzato! Scegline un altro!");
            return false;
        }
        return true;
    }

    /**
     * metodo che permette la registrazione di un configuratore con controllo sul nome utente
     * @param nomeUtente
     * @param pass
     */
    
    public void registraNuovoConfiguratore(String nomeUtente, String pass) {
        boolean val = controlloCredenzialiNomeUtente(nomeUtente);
        if (val) {
            aggiungiDatiAllaMappa(nomeUtente, pass);
        }
    }

    /**
     * Controlla se i dati inseriti dall'utente (nome utente e password) sono corretti
     * @param nomeUtente
     * @param pass password
     * @return restituisce vero se li trova, altrimenti falso
     */
    public boolean ctrlAccesso(String nomeUtente, String pass){
        if(mappaUtenti.containsKey(nomeUtente) && mappaUtenti.containsValue(pass)) {
            return true;
        }
        return false;
    }

    
}
