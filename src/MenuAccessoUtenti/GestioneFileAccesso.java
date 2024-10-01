package menuAccessoUtenti;

import java.io.*;
import java.util.HashMap;

import utilitaGenerale.InputDati;

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


    /* Controllo se i dati inseriti dall'utente sono corretti*/
    public boolean ctrlAccesso(String nomeUtente,String pass){
        if(mapConfiguratori.containsKey(nomeUtente) && mapConfiguratori.containsValue(pass)) {
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

    /* metodo utilizzato per la configurazione iniziale, in quanto mette all'interno della mappa tutti i nomi utenti
     * e password
     * OSS: NON ANCORA TESTATO */

    public void configuraMappa() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file_configuratori));
        for(HashMap.Entry<String,String> entry : mapConfiguratori.entrySet()){
            String parola= br.readLine();
            while(parola!=null && !parola.equals("\n")){
                String [] dati = parola.split(" ");
                String nome = dati[0];
                String pass = dati[1];
                mapConfiguratori.put(nome,pass);

                parola=br.readLine();
            }
        }
    }

    /* metoto usato per l'accesso del configuratore
     * OSS: ANCORA DA TESTARE */
    public void accessoConfig(){
        String nomeUtente= InputDati.leggiStringaNonVuota("Inserisci il tuo nome utente:");
        String pass = InputDati.leggiStringaNonVuota("Inserisci la tua password:");
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


    /*metodo che permette la registrazione di un configuratore con controllo sul nome utente
     * OSS: ANCORA DA TESTARE*/
    public void registraConfig() {
        boolean val;
        do {
            val = true;
            String nomeUtente = InputDati.leggiStringaNonVuota("Insersci il nome utente che vuoi utilizzare:");
            if (ctrlNomeUtente(nomeUtente)) {
                String pass = InputDati.leggiStringaNonVuota("Inserisci la tua password personale:");
                aggiungiDati(nomeUtente, pass);
                val = false;
            }
        }while (val);
    }


    /*Controllo sull'unicità del nome utente, se il nome utente non è presente ritorna true e si procede con
    * la registrazione tramite il metodo registraConfig()
    OSS: ANCORA DA TESTARE*/
    private boolean ctrlNomeUtente(String nomeUtente){
        if(mapConfiguratori.containsKey(nomeUtente))
        {
            System.out.println("Nome utente già utilizzato! Scegline un altro!");
            return false;
        }
        return true;
    }
}