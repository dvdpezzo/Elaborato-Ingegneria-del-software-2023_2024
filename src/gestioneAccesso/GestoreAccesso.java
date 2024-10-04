package gestioneAccesso;

import java.io.*;
import java.util.HashMap;
import model.*;

/**
 * Classe che si occupa solo della gestione della mappa delle credenziali
 */
public class GestoreAccesso {

    private final static String UTENTE_DEFAULT="admin";
    private final static String PASS_DEFAULT="admin";
    private final static File file_configuratori = new File("File di accesso\\credenzialiConfiguratori.txt");
    //private final static File file_fruitori = new File("File di accesso\\credenzialiFruitori.txt");

    private HashMap<String, String> mappaCredenzialiUtenti = new HashMap<>();
    private GestoreFileCredenziali gestoreFile;
    private GestoreUtenti gestoreUtenti;
    

    public GestoreAccesso() {       
        this.gestoreFile = new GestoreFileCredenziali(mappaCredenzialiUtenti);        
        try {
            gestoreFile.configuraMappaCredenzialiDaFile(file_configuratori);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.gestoreUtenti = new GestoreUtenti(gestoreFile);
    }
    /**
     * permette l'accesso all'utente: controlla prima di tutto che non sia il primo accesso,
     * altrimenti controlla le credenziali e se sono valide, permette l'accesso
     * @param nomeUtente
     * @param passUtente
     * @return nuovoUtente se è il primo accesso, existingUtente se l'accesso è andato a buon fine, null se le credenziali sono errate
     */
    public Utente accessoUtente(String nomeUtente, String passUtente ){
        if(nomeUtente.equals(UTENTE_DEFAULT) && passUtente.equals(PASS_DEFAULT)){
            return registrazioneNuovoUtente();
        }else
        {
            if(controlloEsistenzaCredenziali(nomeUtente, passUtente)){                
                Utente existingUtente = gestoreUtenti.trovaUtente(nomeUtente);
                System.out.println("Accesso effettuato corretamente!");
                return existingUtente;
            }
            else{
                System.out.println("ERRORE! Nome Utente o password errati!");
                return null;
            }
        }

    }
    /**
     * Inserisce le credenziali nella mappa e salva sul file
     * @return
     */
    private Utente registrazioneNuovoUtente() {
        System.out.println("Sei stasto reindirizzato alla creazione del tuo Nome utente e Password personali:");
        Configuratore newUtente = gestoreUtenti.creaUtenteConfiguratore();
        aggiungiCredenzialiAllaMappa(newUtente.getNomeUtente(), newUtente.getPassword());
        return newUtente;
    }
    /**
     * Permette di aggiungere nome utente e password nella mappa e le salva sul file
     * @param nomeUtente 
     * @param pass password
     * @throws IOException 
     */
    private void aggiungiCredenzialiAllaMappa(String nomeUtente, String pass) {
        mappaCredenzialiUtenti.put(nomeUtente, pass);
        try {
            gestoreFile.salvaMappaCredenzialiSuFile(file_configuratori);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Controlla se i dati inseriti dall'utente (nome utente e password) sono corretti
     * @param nomeUtente
     * @param pass password
     * @return restituisce vero se li trova, altrimenti falso
     */
    private boolean controlloEsistenzaCredenziali (String nomeUtente, String pass){
        return mappaCredenzialiUtenti.containsKey(nomeUtente) && mappaCredenzialiUtenti.containsValue(pass);
    }   
}
