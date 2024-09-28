package MenuAccessoUtenti;

import java.io.*;
import java.util.HashMap;

/*classe usata per la gestione del file di accesso con nomi utenti e password +metodi di controllo */
public class GestioneFileAccesso {

    private final static String UTENTE_DEFAULT="Utente000";
    private final static String PASS_DEFAULT="Pass000";



    private static final File file_configuratori = new File("C:/Users/Mazza/Desktop/prova.txt");
    private final HashMap<String,String> mapConfiguratori = new HashMap<>();

    /*metodo che permette di aggiungere nome utente e pass nella mappa*/
    public void aggiungiDati(String nomeUtente, String pass){
        mapConfiguratori.put(nomeUtente,pass);
    }

    /*metodo che mi permette di aggiungere i dati della mappa nel file*/
    public void salvaMappa() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file_configuratori));
        for (HashMap.Entry<String,String> entry : mapConfiguratori.entrySet()) {
            String configuratore = entry.getKey() + " " + entry.getValue();
            bw.write(configuratore);
            bw.newLine();
        }
        bw.close();
    }


    /* Controllo sul nome utente quando avviene la registraione*/
    public boolean ctrlAccesso(String nomeUtente){
        if(mapConfiguratori.containsKey(nomeUtente)) {
            return true;
        }
        return false;
    }


    /*metodo che controlla se i dati inseriti sono quelli di default oppure no*/
    private boolean primoAccesso(String nomeUtente, String pass){
        if(nomeUtente.equals(UTENTE_DEFAULT) && pass.equals(PASS_DEFAULT)){
            return true;
        }
        return false;
    }

    /*
    a)metodo che mi permette di creare un nuovo account dopo l'accesso di default
    b)metodo che mi permette di gestire il reidirizzamento dopo l'accesso di default
    c)metodo che mi permatta di aggiornare i dati inseriti dagli utenti.
    d)metodo che mi verifichi l'accesso
    e)servirebbero dei metodi set e get per le chiavi e il valore della mappa

     */




}