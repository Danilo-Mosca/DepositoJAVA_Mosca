/* ESERCIZIO: Design pattern ES Decorator

Esercizio Facile:
Obiettivo: creare una struttura base del pattern Decorator per decorare un messaggio di testo.

Richiesta:
- Crea un'interfaccia Messaggio con un metodo String getContenuto().
- Implementa una classe concreta MessaggioBase che restituisce un messaggio semplice.
- Crea un decoratore DecoratoreMaiuscolo che trasforma il messaggio in maiuscolo.
- Scrivi una classe Main per mostrare il messaggio decorato a console.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        /* ---------- TEST FUNZIONAMENTO ---------- */
        // Creo un'instanza della classe MessaggioBase che implementa l'interfaccia Messaggio
        // Messaggio msg = new MessaggioBase();
        // String testoMessaggio = msg.getContenuto("Testo di prova");
        // System.out.println(testoMessaggio);
        // System.out.println("-----------------");
        // msg = new DecoratoreMaiuscolo(msg);
        // System.out.println(msg.getContenuto(testoMessaggio));
        /* ---------- FINE TEST FUNZIONAMENTO ---------- */

        // Creo lo Scanner per l'input dell'utente:
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci un nuovo messaggio: ");
        String messaggioInput = input.nextLine();
        Messaggio msg = new MessaggioBase();
        String testoMessaggio = msg.getContenuto(messaggioInput);
        System.out.println(testoMessaggio);
        System.out.println("--------- Messaggio del decorator --------");
        msg = new DecoratoreMaiuscolo(msg);
        System.out.println("Messagio del decorator in maiuscolo: " + msg.getContenuto(testoMessaggio));
    }
}