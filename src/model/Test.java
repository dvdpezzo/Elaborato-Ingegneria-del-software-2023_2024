package model;
import menuAccessoUtenti.*;

public class Test {
    public static void main(String[] args) {        

		GestoreAccesso ga = new GestoreAccesso();
        //test di avvio del menu 
		MenuAccesso menu1 = new MenuAccesso();
		menu1.avvio(ga);

    }
    
}
