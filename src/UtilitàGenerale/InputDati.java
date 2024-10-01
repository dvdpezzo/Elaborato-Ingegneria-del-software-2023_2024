package UtilitàGenerale;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputDati{

    private static Scanner lettore = creaScanner();

    private final static String ERRORE_FORMATO = "Attenzione: il dato inserito non e' nel formato corretto";
    private final static String ERRORE_MINIMO= "Attenzione: e' richiesto un valore maggiore o uguale a ";
    private final static String ERRORE_STRINGA_VUOTA= "Attenzione: non hai inserito alcun carattere";
    private final static String ERRORE_MASSIMO= "Attenzione: e' richiesto un valore minore o uguale a ";
    private final static String MESSAGGIO_AMMISSIBILI= "Attenzione: i caratteri ammissibili sono: ";


    private final static char RISPOSTA_SI='S';
    private final static char RISPOSTA_NO='N';



    private static Scanner creaScanner ()
    {
        Scanner creato = new Scanner(System.in);
        creato.useDelimiter(System.getProperty("line.separator"));
        return creato;
    }

    public static String leggiStringa (String messaggio)
    {
        System.out.print(messaggio);
        return lettore.next();
    }

    public static String leggiStringaNonVuota(String messaggio)
    {
        boolean finito=false;
        String lettura = null;
        do
        {
            lettura = leggiStringa(messaggio);
            lettura = lettura.trim();
            if (lettura.length() > 0)
                finito=true;
            else
                System.out.println(ERRORE_STRINGA_VUOTA);
        } while (!finito);

        return lettura;
    }

    public static char leggiChar (String messaggio)
    {
        boolean finito = false;
        char valoreLetto = '\0';
        do
        {
            System.out.print(messaggio);
            String lettura = lettore.next();
            if (lettura.length() > 0)
            {
                valoreLetto = lettura.charAt(0);
                finito = true;
            }
            else
            {
                System.out.println(ERRORE_STRINGA_VUOTA);
            }
        } while (!finito);
        return valoreLetto;
    }

    public static char leggiUpperChar (String messaggio, String ammissibili)
    {
        boolean finito = false;
        char valoreLetto = '\0';
        do
        {
            valoreLetto = leggiChar(messaggio);
            valoreLetto = Character.toUpperCase(valoreLetto);
            if (ammissibili.indexOf(valoreLetto) != -1)
                finito  = true;
            else
                System.out.println(MESSAGGIO_AMMISSIBILI + ammissibili);
        } while (!finito);
        return valoreLetto;
    }


    public static int leggiIntero (String messaggio)
    {
        boolean finito = false;
        int valoreLetto = 0;
        do
        {
            System.out.print(messaggio);
            try
            {
                valoreLetto = lettore.nextInt();
                finito = true;
            }
            catch (InputMismatchException e)
            {
                System.out.println(ERRORE_FORMATO);
                String daButtare = lettore.next();
            }
        } while (!finito);
        return valoreLetto;
    }

    public static int leggiInteroPositivo(String messaggio)
    {
        return leggiInteroConMinimo(messaggio,1);
    }

    public static int leggiInteroNonNegativo(String messaggio)
    {
        return leggiInteroConMinimo(messaggio,0);
    }