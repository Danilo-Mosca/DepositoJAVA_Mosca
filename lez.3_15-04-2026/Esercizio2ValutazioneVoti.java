/* ------------------------------------------------------------------
Esercizio: Valutazione voti con controlli
Scrivi un programma Java che:
Chiede all’utente quanti voti vuole inserire (intero positivo).
Usa un ciclo while per validare che il numero sia maggiore di zero.
Poi usa un ciclo for per inserire ogni voto.
Ogni voto deve essere un numero compreso tra 0 e 30 (estremi inclusi).
Se il voto è valido:
- Se è maggiore o uguale a 18 e minore di 24, stampa "Sufficiente"
- Se è maggiore o uguale a 24, stampa "Buono o Ottimo"
- Altrimenti stampa "Insufficiente"
Se il voto non è valido (fuori range), stampa "Voto non valido" e non lo contatra quelli validi.
Alla fine, stampa il numero totale di voti validi inseriti. 
------------------------------------------------------------------ */

import java.util.Scanner;           // Importo la classe Scanner

public class Esercizio2ValutazioneVoti {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);         // Crea un oggetto Scanner

        int numeroVoti = 0;         // contatore dei numero di voti totali da inserire, che inizializzo a zero

        // Ciclo WHILE: utilizzato per validare che il numero dei voti da inserire sia > 0: assicura che l'utente inserisca solo numeri positivi
        while (numeroVoti <= 0) {
            System.out.println("Quanti voti vuoi inserire?");
            numeroVoti = input.nextInt();       // Leggo un user input: nextLine() legge e accetta valori di tipo interi
            
            // Controllo che l'utente abbia inserito un numero intero positivo:
            if (numeroVoti <= 0) {
                System.out.println("Inserisci un numero maggiore di 0");
            }
        }

        
        int votiValidi = 0;         // contatore dei numero di voti validi

        // Ciclo FOR: utilizzato per per l'inserimento dei voti
        for (int i = 1; i <= numeroVoti; i++) {
            System.out.println("Inserisci il voto " + i + ":");
            int voto = input.nextInt();         // Leggo un user input: nextLine() legge e accetta valori di tipo interi

            // Controllo validità voto (che deve essere compreso tra 1 e 29)
            if (voto <= 0 || voto > 30) {
                System.out.println("Voto non valido");
                continue; // salta al prossimo giro
            }

            votiValidi++;       // incremento il contatore dei voti validi

            // Valutazione voto
            if (voto < 18) {
                System.out.println("Insufficiente");
            } else if (voto < 24) {
                System.out.println("Sufficiente");
            } else {
                System.out.println("Buono o Ottimo");
            }
        }

        // Stampo il risultato finale con il numero totale di voti validi:
        System.out.println("Numero totale di voti validi: " + votiValidi);

        input.close();      // Chiudo lo Scanner "input" e libero le risorse
    }
}
