package gestioneAccesso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;


/**
 * Classe che si occupa solo della gestione della mappa delle credenziali
 */
public class GestoreAccesso {

    private static final String FILE_DI_ACCESSO_CREDENZIALI_FRUITORI_TXT = "File di accesso\\credenzialiFruitori.txt";
    private static final String FILE_DI_ACCESSO_CREDENZIALI_CONFIGURATORI_TXT = "File di accesso\\credenzialiConfiguratori.txt";
    private static final String UTENTE_DEFAULT="Utente000";
    private static final String PASS_DEFAULT="Pass000";
    
    private File file_configuratori = new File(FILE_DI_ACCESSO_CREDENZIALI_CONFIGURATORI_TXT);
    private File file_fruitori = new File(FILE_DI_ACCESSO_CREDENZIALI_FRUITORI_TXT);

    private HashMap<String, String> mappaConfiguratori = new HashMap<>();
    private HashMap<String, String> mappaFruitori = new HashMap<>();
    private GestoreFileAccesso gestoreFileConfiguratori;
    private GestoreFileAccesso gestoreFileFruitori;

    public GestoreAccesso() {
        this.gestoreFileConfiguratori = creaGestoreFileAccesso(mappaConfiguratori, file_configuratori);
        this.gestoreFileFruitori = creaGestoreFileAccesso(mappaFruitori, file_fruitori);
    }

    private GestoreFileAccesso creaGestoreFileAccesso(HashMap<String, String> mappa, File file){
        GestoreFileAccesso gestoreFile = new GestoreFileAccesso(mappa); 
        try {
            gestoreFile.configuraMappaDaFile(file);
        }  catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }    
        return gestoreFile;        
    }     
    public boolean accessoUtente(String nomeUtente, String password) {
        if (isCoordinatore(nomeUtente, password)) {
            System.out.println("Accesso riuscito.");
            return true;
        } else if (isFruitore(nomeUtente, password)) {
            System.out.println("Accesso riuscito.");
            return true;
        } else {
            System.out.println("Accesso non riuscito.");
            return false;
        }
    }
    /**
     * Aggiunge un nuovo utente alla mappa e al file specificati
     * @param nomeUtente Nome utente da aggiungere
     * @param password Password dell'utente
     * @param mappa Mappa in cui aggiungere l'utente (mappaConfiguratori o mappaFruitori)
     * @param file File in cui salvare le credenziali
     * @throws IOException Se si verifica un errore durante il salvataggio su file
     */
    public void aggiungiUtente(String nomeUtente, String password, HashMap<String, String> mappa, File file) throws IOException {
        if (controlloCredenzialiNomeUtente(nomeUtente, password, mappa)) {
            mappa.put(nomeUtente, password);
            GestoreFileAccesso gestoreFile = (mappa == mappaConfiguratori) ? gestoreFileConfiguratori : gestoreFileFruitori;
            gestoreFile.salvaMappaSuFile(file);
            System.out.println("Utente aggiunto con successo.");
        } else {
            System.out.println("Impossibile aggiungere l'utente. Nome utente già esistente.");
        }
    }    
    /**
     * Rimuove un utente dalla mappa e dal file specificati
     * @param nomeUtente Nome utente da rimuovere
     * @param mappa Mappa da cui rimuovere l'utente (mappaConfiguratori o mappaFruitori)
     * @param file File da cui rimuovere le credenziali
     * @throws IOException Se si verifica un errore durante il salvataggio su file
     */
    public void rimuoviUtente(String nomeUtente, HashMap<String, String> mappa, File file) throws IOException {
        if (mappa.containsKey(nomeUtente)) {
            mappa.remove(nomeUtente);
            GestoreFileAccesso gestoreFile = (mappa == mappaConfiguratori) ? gestoreFileConfiguratori : gestoreFileFruitori;
            gestoreFile.salvaMappaSuFile(file);
            System.out.println("Utente rimosso con successo.");
        } else {
            System.out.println("Utente non trovato. Impossibile rimuovere.");
        }
    }

    /**
     * Verifica se un utente è un coordinatore
     * @param nomeUtente Nome utente da verificare
     * @param password Password dell'utente
     * @return true se l'utente è un coordinatore, false altrimenti
     */
    public boolean isCoordinatore(String nomeUtente, String password) {
        return mappaConfiguratori.containsKey(nomeUtente) && mappaConfiguratori.get(nomeUtente).equals(password);
    }

    /**
     * Verifica se un utente è un fruitore
     * @param nomeUtente Nome utente da verificare
     * @param password Password dell'utente
     * @return true se l'utente è un fruitore, false altrimenti
     */
    public boolean isFruitore(String nomeUtente, String password) {
        return mappaFruitori.containsKey(nomeUtente) && mappaFruitori.get(nomeUtente).equals(password);
    }
    
    /**
     * Controllo sull'unicità del nome utente
     * @param nomeUtente
     * @return se il nome utente non è presente ritorna true
     */
    private boolean controlloCredenzialiNomeUtente(String nomeUtente, String pass, HashMap<String, String> mappa){
        if(mappa.containsKey(nomeUtente))
        {
            System.out.println("Nome utente già utilizzato! Scegline un altro!");
            return false;
        }
        return true;
    }
    /**
     * Controlla se si sta facendo il primo accesso analizzando i dati inseriti se sono quelli di default
     * @param nomeUtente Nome utente sul quale effettuare il controllo
     * @param pass Password dell'utente
     * @return vero se si sta effettuando il primo accesso, falso altrimenti
     */
    public boolean primoAccesso(String nomeUtente, String pass){
        return nomeUtente.equals(UTENTE_DEFAULT) && pass.equals(PASS_DEFAULT);
    }


}
