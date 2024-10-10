package model;

import java.util.LinkedList;



//classe che gestisce l'elenco dei comuni inseriti dal configuratore
public class GestoreComuni {

    private final String MSG_ERRORE_COMUNE="Comune già presente nella lista";



    public LinkedList<Comuni> listaComuni = new LinkedList<>();



    //aggiunge un comune alla lista
    public void aggiungiComune(Comuni comune){
        if(conrtolloComuni(comune)){
            System.out.println(MSG_ERRORE_COMUNE);
        }
        else{
            listaComuni.add(comune);
        }
    }


    //controllo inserimento del comune in base al nome 
    public boolean conrtolloComuni(Comuni comune){
      if(listaComuni.contains(comune.getNome())) return true;
      else return false;
    }


    //visualizza elenco comuni
    public void visualizzaComuni(){
        for(int i=0;i<listaComuni.size();i++){
            System.out.println(listaComuni.get(i).getNumero()+" "+listaComuni.get(i).getNome());
        }
    }

    //metodo per la scelta del comune da inserire nel compensporio geografico
    public Comuni scegliComune(int n){
        for(int i=0;i<listaComuni.size();i++){
            if(listaComuni.get(i).getNumero()==n){
                return listaComuni.get(i);
            }
        }
        return null;
    }

    /*
     * DA FARE: 
     * OSS: Forse con i comuni è troppo? semplificare in qualche modo il tutto.
     * a) metodo che salva i comuni su file
     * b) metodo che aggiorna i comuni se vengono aggiunti (anche sul file)
     */
    
}
