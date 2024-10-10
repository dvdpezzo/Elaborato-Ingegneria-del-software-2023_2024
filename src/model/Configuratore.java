package model;

import java.util.LinkedList;
import java.util.List;

import utilitaGenerale.InputDati;

public class Configuratore extends Utente  {
    private static final String DEFAULT = "admin";

    

    public Configuratore(String nomeUtente, String passwordUtente) {
        super(nomeUtente, passwordUtente);
    }

 /* a)visualizza la lista dei comuni e ne fa inserire 3 al coordinatore
    b)aggiunge i 3 comuni alla LinkedList e la passa al costruttore del comprensorio geografico
*/


/* crea un compensorioGeofratico partento dalla lista dei comuni, l'utente decide quali comuni inserire in base al numero inserito
   esegue anche un controllo sul comune scelto per evitare che si ripeta lo stesso. 
 */
    public ComprensorioGeografico creaComprensorioGeografico(){
        List<Comuni> listaComuni = new LinkedList<Comuni>();
        GestoreComuni gc = new GestoreComuni();

        stampaComuni();
        boolean val = true;
         do{
           int n = InputDati.leggiIntero("Inserisci il numero del primo comune che vuoi aggiungere al comprensorio:");
           Comuni comune_1 = gc.scegliComune(n);
           listaComuni.add(comune_1);
           int p = InputDati.leggiIntero("Inserisci il numero del secondo comune:");
           Comuni comune_2 = gc.scegliComune(p);
           if(comune_1.equals(comune_2)){
            System.out.println("QUESTO COMUNE E GIA STATO INSERITO!");
            val=false;
           }
           else
           {
              listaComuni.add(comune_2);
              int q = InputDati.leggiIntero("Inserisci il numero del terzo comune:");
              Comuni comune_3=gc.scegliComune(q);
                 if(comune_3.equals(comune_1) || comune_3.equals(comune_2))
                 {
                    System.out.println("QUESTO COMUNE E GIA STATO INSERITO!");
                   val=false;
                 }
                 else listaComuni.add(comune_3);
           }
         }while(val);
        return new ComprensorioGeografico(listaComuni);
    }    

    public void salvaCambiamenti(){}

    public void visualizzaComprensori(){}
    public void visualizzaGerarchia(){}
    public void visualizzaFattoriConversione(){}

    List<Categoria> creaGerarchia() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    Categoria creaCategoria() {
        throw new UnsupportedOperationException("Not supported yet.");
    }



    public void stampaComuni()
    {
        GestoreComuni gestore = new GestoreComuni();
        gestore.visualizzaComuni();
    }

}
