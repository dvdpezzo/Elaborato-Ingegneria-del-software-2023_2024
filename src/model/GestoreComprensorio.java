package model;

import java.util.HashMap;
import java.io.*;


//classe che gestisce l'elenco dei comprensori inseriti dal configuratore
public class GestoreComprensorio {

    public HashMap<Integer,ComprensorioGeografico> comprensori = new HashMap<>();
    private File fileComprensori = new File("C:\\Users\\Mazza\\Desktop\\ign soft 2023 2024\\Elaborato-Ingegneria-del-software-2023_2024\\File di accesso\\elencoComprensori");



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

    //salva la mappa sul file elencoComprensori
    public void scriviComprensorio() throws IOException{
         BufferedWriter bw = new BufferedWriter(new FileWriter(fileComprensori));
        for (HashMap.Entry<Integer,ComprensorioGeografico> entry : comprensori.entrySet()){
            String comprensorio = entry.getKey()+ " "+ entry.getValue().getListaComuni();
            bw.write(comprensorio);
            bw.newLine();
        }
        bw.close();
    }


    /*legge la mappa dei comprensori da file 
    OSS: Non ho idea di come svilupparlo visto che devo passare un argomento Comprensorio.
    */
    public void leggiComprensorio()throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(fileComprensori))){




    }



}

}
    

    
    


    



