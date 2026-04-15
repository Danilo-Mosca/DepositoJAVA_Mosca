/* ------------------------------------------------------------------
Esercizio: Array
Esercizio: Gestione ordini in una pasticceria

Scrivi un programma Java per una pasticceria che:

Chiede all’utente quanti dolci diversi vuole ordinare (massimo 10).
Usa due array paralleli:
- Uno per memorizzare il nome del dolce (array di String)
- Uno per memorizzare la quantità ordinata (array di int)

Dopo aver raccolto i dati, il programma deve:
- Stampare l’elenco degli ordini effettuati
- Calcolare e stampare la quantità totale di dolci ordinati

Se l’utente inserisce un numero negativo per la quantità, stampare unmessaggio di errore e richiedere nuovamente il dato per quel dolce.

------------------------------------------------------------------ */

import java.util.Scanner; // Importo la classe Scanner

public class Esercizio3Pasticceria {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);         // Crea un oggetto Scanner

        final int numeroMassimoDolci = 10;              // Costante contenente il numero massimo di dolci diversi inseribili
        int numeroDolciDiversi;                         // variabile che conterrà l'input dell'utente

        
        // Blocco di codice "Richiesta numero dolci" (massimo 10)
        do {
            System.out.print("Quanti dolci diversi vuoi ordinare? (massimo 10): ");
            numeroDolciDiversi = input.nextInt();            // Leggo un user input: nextLine() legge e accetta valori di tipo interi
        } while (numeroDolciDiversi <= 0 || numeroDolciDiversi > numeroMassimoDolci);
        // Fine blocco di codice "Richiesta numero dolci"

        
        
        // Array paralleli per nomi e quantità:
        String[] nomiDolci_a = new String[numeroDolciDiversi];
        int[] quantita_a = new int[numeroDolciDiversi];

        // Blocco Inserimento dati all'interno dei due array paralleli: nomiDolci_a, quantita_a
        for (int i = 0; i < numeroDolciDiversi; i++) {
            System.out.print("Inserisci il nome del dolce numero " + (i + 1) + ": ");
            nomiDolci_a[i] = input.next();        // Leggo un user input: nextLine() legge e accetta valori di tipo interi

            // Controllo quantità: non devono essere numeri negativi o uguali a zero
            do {
                System.out.print("Inserisci la quantità: ");
                quantita_a[i] = input.nextInt();
                // Se la quantità è un valore negativo allora stampo un errore:
                if (quantita_a[i] <= 0) {
                    System.out.println("Errore: la quantità non può essere negativa o uguale a zero!");
                }

            } while (quantita_a[i] <= 0);    // Se la quantità inserita dall'utente per quel singolo dolce non è maggiore di zero allora faccio ricominciare il ciclo do..while
        }
        // Fine Blocco Inserimento dati all'interno dei due array paralleli

        
        
        // Ciclo che Stampa gli ordini contenenti sia il nome che la quantità ordinata:
        System.out.println("\n-------- ELENCO ORDINI --------");
        for (int i = 0; i < numeroDolciDiversi; i++) {
            System.out.println(nomiDolci_a[i] + " - " + quantita_a[i]);

        }

        // Calcolo totale della quantità totale dei dolci ordinati
        int totale = 0;
        for (int i = 0; i < numeroDolciDiversi; i++) {
            totale += quantita_a[i];
        }
        System.out.println("\nTotale dolci ordinati: " + totale);   // stampo a schermo il la quantità totale dei dolci ordinati

        input.close();      // Chiudo lo Scanner "input" e libero le risorse
    }

}
