package UtilitàGenerale;

/* Classe che contiene metodi di utilità di generale per il menu di accesso del coordinatore */


public class MenuUtill {

    final private static String CORNICE = "--------------------------------";
    final private static String VOCE_USCITA = "0\tEsci";
    final private static String INSERIMENTO_UTENTE = "Digitare il numero dell'opzione desiderata:";

    private String titolo;
    private String [] voci;

    public MenuUtill(String titolo, String [] voci){
        this.titolo=titolo;
        this.voci = voci;
    }

    public void stampaMenu(){
        System.out.println(CORNICE);
        System.out.println(titolo);
        System.out.println(CORNICE);

        for(int i=0;i<voci.length;i++){
            System.out.println((i+1)+ "\t" + voci[i]);
        }
        System.out.println("\n"+VOCE_USCITA+"\n");
    }

    public int scelta(){
        stampaMenu();
        return InputDati.leggiIntero(INSERIMENTO_UTENTE,0,voci.length);
    }


}

