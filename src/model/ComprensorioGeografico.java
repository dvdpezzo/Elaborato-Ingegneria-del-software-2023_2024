package model;

import java.util.*;
public class ComprensorioGeografico {

    private int codice;
    public List<Comuni> listaComuni = new ArrayList<>(); //non posso mettere List()
    
    
    public ComprensorioGeografico(List<Comuni> listaComuni){
        this.codice=generaCodice();
        this.listaComuni=listaComuni;
    }


    public int getCodice() {
        return codice;
    }
   
    //metodo per la creazione del codice da 0 a 9000
    private int generaCodice(){
        Random random = new Random();
        return 0000 + random.nextInt(9000);

    }



}
