package model;

import java.util.HashMap;


//classe che gestisce l'elenco dei comprensori inseriti dal configuratore
public class GestoreComprensorio {

    public HashMap<Integer,ComprensorioGeografico> comprensori = new HashMap<>();



    //aggiungo un comprensorio alla mappa
    public void aggiungiComprensorio(ComprensorioGeografico c1){
        if(controlloComprensorio(c1)){
            System.out.println("COMPRENSORIO GIA ESISTENTE!");
        }
        else{
        comprensori.put(c1.getCodice(),c1);
        }
    }


    //controlla se il compensorio sia già presente oppure no
    public boolean controlloComprensorio(ComprensorioGeografico c1){
        if(comprensori.containsKey(c1.getCodice())) return true;
        else return false;
    }



    

    /* SERVONO:
     * A)Metodo che stampa la mappa dei comprensori
     * B)Metodo che salva la mappa dei comprensori su file
     * C)Metodo che aggiorna la mappa dei comprensori su file
     */




    


}
