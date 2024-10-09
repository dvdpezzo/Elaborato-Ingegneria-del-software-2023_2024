package model;

import java.util.LinkedList;

/*  
 * IDEA: 
 * a)il configuratore inserisce un elenco di comuni a suo piacimento (con opzione Y o N per continuare),
 * b)creazione di tutti i compensori geografici che vuole. (3 comuni)
 * 
*/

public class Comuni {

    LinkedList<String> paesi = new LinkedList<String>();



    public void aggiungiComune(String comune){
        paesi.add(comune);
    }


    public boolean conrtolloComuni(String comune){
      if(paesi.contains(comune)) return true;
      else return false;
    }

    






   









    
}
