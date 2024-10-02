package gestioneAccesso;

import java.io.*;
import java.util.HashMap;

/**
 * classe usata per la gestione del file di accesso dei configuratori e fruitori:
 * deve solo leggere i file e inserirli nella mappa, o viceversa leggere la mappa e inserirli nel file 
*/
public class GestoreFileAccesso {
    
    private HashMap<String, String> mappaUtenti;    

    public GestoreFileAccesso(HashMap<String, String> mappaUtenti) {
        this.mappaUtenti = mappaUtenti;
    }

    /**
     * Permette di aggiungere nuove credenziali dalla mappa al file
     * @throws IOException
     */
    public void salvaMappaSuFile(File pathFile) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(pathFile));
        for (HashMap.Entry<String,String> entry : mappaUtenti.entrySet()) {
            String utente = entry.getKey() + " " + entry.getValue();
            bw.write(utente);
            bw.newLine();
        }
        bw.close();
    }
    /**
     * Effettua configurazione iniziale della mappa: legge il file delle credenziali e imposta per ogni riga
     * nome utente e password
     * @throws FileNotFoundException 
     * @throws IOException
     */
    public void configuraMappaDaFile(File pathFile) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            String parola = br.readLine();
            while (parola != null && !parola.equals("\n") &&!parola.isEmpty() && parola.charAt(0)!='\t') {
                String [] dati = parola.split(" ");
                String nome = dati[0];
                String pass = dati[1];
                mappaUtenti.put(nome,pass);
                parola = br.readLine();
            }
        }
    }   
}